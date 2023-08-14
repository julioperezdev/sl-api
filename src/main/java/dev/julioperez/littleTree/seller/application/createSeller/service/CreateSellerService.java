package dev.julioperez.littleTree.seller.application.createSeller.service;

import dev.julioperez.littleTree.seller.domain.dto.CreateSellerRequest;
import dev.julioperez.littleTree.seller.domain.model.Seller;
import dev.julioperez.littleTree.seller.domain.port.createSeller.CreateSeller;
import dev.julioperez.littleTree.seller.domain.port.createSeller.CreateSellerOutputPort;
import dev.julioperez.littleTree.seller.domain.port.mapper.SellerMapper;

public class CreateSellerService implements CreateSeller {
    private final CreateSellerOutputPort createSellerOutputPort;
    private final SellerMapper sellerMapper;

    public CreateSellerService(CreateSellerOutputPort createSellerOutputPort, SellerMapper sellerMapper) {
        this.createSellerOutputPort = createSellerOutputPort;
        this.sellerMapper = sellerMapper;
    }

    @Override
    public Seller createSeller(CreateSellerRequest createSellerRequest) throws Exception {
        Seller seller = sellerMapper.toSellerModel(createSellerRequest);
        return createSellerOutputPort.createSeller(seller);
    }
}
