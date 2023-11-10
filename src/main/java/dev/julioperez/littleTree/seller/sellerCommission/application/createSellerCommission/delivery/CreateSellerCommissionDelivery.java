package dev.julioperez.littleTree.seller.sellerCommission.application.createSellerCommission.delivery;

import dev.julioperez.littleTree.seller.sellerCommission.domain.dto.CreateSellerCommissionRequest;
import dev.julioperez.littleTree.seller.sellerCommission.domain.model.SellerCommission;
import dev.julioperez.littleTree.seller.sellerCommission.domain.port.createSellerCommission.CreateSellerCommission;
import dev.julioperez.littleTree.seller.sellerCommission.domain.port.createSellerCommission.CreateSellerCommissionInputPort;

public class CreateSellerCommissionDelivery implements CreateSellerCommissionInputPort {
    private final CreateSellerCommission createSellerCommission;

    public CreateSellerCommissionDelivery(CreateSellerCommission createSellerCommission) {
        this.createSellerCommission = createSellerCommission;
    }

    @Override
    public SellerCommission createSellerCommission(CreateSellerCommissionRequest createSellerCommissionRequest) {
        return createSellerCommission.createSellerCommission(null);
    }
}
