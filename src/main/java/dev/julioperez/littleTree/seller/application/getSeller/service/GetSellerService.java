package dev.julioperez.littleTree.seller.application.getSeller.service;

import dev.julioperez.littleTree.seller.domain.model.Seller;
import dev.julioperez.littleTree.seller.domain.port.getSeller.GetSeller;
import dev.julioperez.littleTree.seller.domain.port.getSeller.GetSellerOutputPort;

import java.util.List;

public class GetSellerService implements GetSeller {
    private final GetSellerOutputPort getSellerOutputPort;

    public GetSellerService(GetSellerOutputPort getSellerOutputPort) {
        this.getSellerOutputPort = getSellerOutputPort;
    }

    @Override
    public List<Seller> getSellers() {
        return getSellerOutputPort.getSellers();
    }
}
