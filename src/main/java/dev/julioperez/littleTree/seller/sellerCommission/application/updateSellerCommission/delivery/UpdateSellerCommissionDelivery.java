package dev.julioperez.littleTree.seller.sellerCommission.application.updateSellerCommission.delivery;

import dev.julioperez.littleTree.seller.sellerCommission.domain.dto.UpdateSellerCommissionRequest;
import dev.julioperez.littleTree.seller.sellerCommission.domain.model.SellerCommission;
import dev.julioperez.littleTree.seller.sellerCommission.domain.port.updateSellerCommission.UpdateSellerCommission;
import dev.julioperez.littleTree.seller.sellerCommission.domain.port.updateSellerCommission.UpdateSellerCommissionInputPort;

public class UpdateSellerCommissionDelivery implements UpdateSellerCommissionInputPort {
    private final UpdateSellerCommission updateSellerCommission;

    public UpdateSellerCommissionDelivery(UpdateSellerCommission updateSellerCommission) {
        this.updateSellerCommission = updateSellerCommission;
    }

    @Override
    public SellerCommission updateSellerCommission(UpdateSellerCommissionRequest updateSellerCommissionRequest) {
        return updateSellerCommission.updateSellerCommission(updateSellerCommissionRequest);
    }
}
