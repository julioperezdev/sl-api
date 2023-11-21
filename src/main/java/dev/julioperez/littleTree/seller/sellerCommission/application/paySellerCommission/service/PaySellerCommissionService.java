package dev.julioperez.littleTree.seller.sellerCommission.application.paySellerCommission.service;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.egressPesosBoxByCommissionPayment.EgressPesosBoxByCommissionPayment;
import dev.julioperez.littleTree.seller.sellerCommission.domain.dto.UpdateSellerCommissionRequest;
import dev.julioperez.littleTree.seller.sellerCommission.domain.enums.SellerCommissionStatus;
import dev.julioperez.littleTree.seller.sellerCommission.domain.model.SellerCommission;
import dev.julioperez.littleTree.seller.sellerCommission.domain.port.paySellerCommission.PaySellerCommission;
import dev.julioperez.littleTree.seller.sellerCommission.domain.port.updateSellerCommission.UpdateSellerCommission;

public class PaySellerCommissionService implements PaySellerCommission {
    private final UpdateSellerCommission updateSellerCommission;
    private final EgressPesosBoxByCommissionPayment egressPesosBoxByCommissionPayment;

    public PaySellerCommissionService(UpdateSellerCommission updateSellerCommission, EgressPesosBoxByCommissionPayment egressPesosBoxByCommissionPayment) {
        this.updateSellerCommission = updateSellerCommission;
        this.egressPesosBoxByCommissionPayment = egressPesosBoxByCommissionPayment;
    }


    @Override
    public boolean execute(String sellerCommissionId) {
        UpdateSellerCommissionRequest updateSellerCommissionRequest = new UpdateSellerCommissionRequest(
                sellerCommissionId,
                SellerCommissionStatus.DONE.value());
        SellerCommission sellerCommission = updateSellerCommission.updateSellerCommission(updateSellerCommissionRequest);
        return egressPesosBoxByCommissionPayment.execute(sellerCommission.getProfit());
    }
}
