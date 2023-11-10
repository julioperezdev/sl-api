package dev.julioperez.littleTree.seller.sellerCommission.application.paySellerCommission.service;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.updateCurrencyMultiBox.UpdateCurrencyMultiBox;
import dev.julioperez.littleTree.seller.sellerCommission.domain.dto.UpdateSellerCommissionRequest;
import dev.julioperez.littleTree.seller.sellerCommission.domain.enums.SellerCommissionStatus;
import dev.julioperez.littleTree.seller.sellerCommission.domain.model.SellerCommission;
import dev.julioperez.littleTree.seller.sellerCommission.domain.port.paySellerCommission.PaySellerCommission;
import dev.julioperez.littleTree.seller.sellerCommission.domain.port.updateSellerCommission.UpdateSellerCommission;

public class PaySellerCommissionService implements PaySellerCommission {
    private final UpdateSellerCommission updateSellerCommission;
    private final UpdateCurrencyMultiBox updateCurrencyMultiBox;

    public PaySellerCommissionService(UpdateSellerCommission updateSellerCommission, UpdateCurrencyMultiBox updateCurrencyMultiBox) {
        this.updateSellerCommission = updateSellerCommission;
        this.updateCurrencyMultiBox = updateCurrencyMultiBox;
    }

    @Override
    public boolean execute(String sellerCommissionId) {
        UpdateSellerCommissionRequest updateSellerCommissionRequest = new UpdateSellerCommissionRequest(
                sellerCommissionId,
                SellerCommissionStatus.DONE.value());
        SellerCommission sellerCommission = updateSellerCommission.updateSellerCommission(updateSellerCommissionRequest);
        return updateCurrencyMultiBox.egressPesosBoxByCommissionPayment(sellerCommission.getProfit());
    }
}
