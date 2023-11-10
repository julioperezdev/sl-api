package dev.julioperez.littleTree.seller.seller.application.createSeller.delivery;

import dev.julioperez.littleTree.seller.seller.domain.dto.CreateSellerRequest;
import dev.julioperez.littleTree.seller.seller.domain.model.Seller;
import dev.julioperez.littleTree.seller.seller.domain.port.createSeller.CreateSeller;
import dev.julioperez.littleTree.seller.seller.domain.port.createSeller.CreateSellerInputPort;

public class CreateSellerDelivery implements CreateSellerInputPort {

    private final CreateSeller createSeller;

    public CreateSellerDelivery(CreateSeller createSeller) {
        this.createSeller = createSeller;
    }

    @Override
    public Seller createSeller(CreateSellerRequest createSellerRequest) throws Exception {
        return createSeller.createSeller(createSellerRequest);
    }
}
