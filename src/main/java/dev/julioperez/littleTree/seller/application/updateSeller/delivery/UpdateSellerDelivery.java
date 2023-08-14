package dev.julioperez.littleTree.seller.application.updateSeller.delivery;

import dev.julioperez.littleTree.seller.domain.dto.UpdateSellerRequest;
import dev.julioperez.littleTree.seller.domain.model.Seller;
import dev.julioperez.littleTree.seller.domain.port.updateSeller.UpdateSeller;
import dev.julioperez.littleTree.seller.domain.port.updateSeller.UpdateSellerInputPort;

public class UpdateSellerDelivery implements UpdateSellerInputPort {
    private final UpdateSeller updateSeller;

    public UpdateSellerDelivery(UpdateSeller updateSeller) {
        this.updateSeller = updateSeller;
    }

    @Override
    public Seller updateSeller(UpdateSellerRequest updateSellerRequest) {
        return updateSeller.updateSeller(updateSellerRequest);
    }
}
