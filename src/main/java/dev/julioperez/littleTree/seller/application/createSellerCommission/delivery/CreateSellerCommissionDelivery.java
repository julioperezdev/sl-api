package dev.julioperez.littleTree.seller.application.createSellerCommission.delivery;

import dev.julioperez.littleTree.seller.domain.dto.CreateSellerCommissionRequest;
import dev.julioperez.littleTree.seller.domain.model.SellerCommission;
import dev.julioperez.littleTree.seller.domain.port.createSellerCommission.CreateSellerCommission;
import dev.julioperez.littleTree.seller.domain.port.createSellerCommission.CreateSellerCommissionInputPort;

public class CreateSellerCommissionDelivery implements CreateSellerCommissionInputPort {
    private final CreateSellerCommission createSellerCommission;

    public CreateSellerCommissionDelivery(CreateSellerCommission createSellerCommission) {
        this.createSellerCommission = createSellerCommission;
    }

    @Override
    public SellerCommission createSellerCommission(CreateSellerCommissionRequest createSellerCommissionRequest) {
        return createSellerCommission.createSellerCommission(createSellerCommissionRequest);
    }
}
