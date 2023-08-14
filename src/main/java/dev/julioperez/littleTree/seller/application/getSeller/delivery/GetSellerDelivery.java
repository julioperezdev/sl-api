package dev.julioperez.littleTree.seller.application.getSeller.delivery;

import dev.julioperez.littleTree.seller.domain.model.Seller;
import dev.julioperez.littleTree.seller.domain.port.getSeller.GetSeller;
import dev.julioperez.littleTree.seller.domain.port.getSeller.GetSellerInputPort;

import java.util.List;

public class GetSellerDelivery implements GetSellerInputPort {
    private final GetSeller getSeller;

    public GetSellerDelivery(GetSeller getSeller) {
        this.getSeller = getSeller;
    }

    @Override
    public List<Seller> getSellers() {
        return getSeller.getSellers();
    }
}
