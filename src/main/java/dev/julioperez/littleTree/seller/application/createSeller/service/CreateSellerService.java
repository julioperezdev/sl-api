package dev.julioperez.littleTree.seller.application.createSeller.service;

import dev.julioperez.littleTree.client.domain.model.Client;
import dev.julioperez.littleTree.seller.domain.dto.CreateSellerRequest;
import dev.julioperez.littleTree.seller.domain.model.Seller;
import dev.julioperez.littleTree.seller.domain.port.createSeller.CreateSeller;
import dev.julioperez.littleTree.seller.domain.port.createSeller.CreateSellerOutputPort;
import dev.julioperez.littleTree.seller.domain.port.getSeller.GetSeller;
import dev.julioperez.littleTree.seller.domain.port.mapper.SellerMapper;

import java.util.Optional;

public class CreateSellerService implements CreateSeller {
    private final CreateSellerOutputPort createSellerOutputPort;
    private final SellerMapper sellerMapper;
    private final GetSeller getSeller;

    public CreateSellerService(CreateSellerOutputPort createSellerOutputPort, SellerMapper sellerMapper,GetSeller getSeller) {
        this.createSellerOutputPort = createSellerOutputPort;
        this.sellerMapper = sellerMapper;
        this.getSeller = getSeller;
    }

    @Override
    public Seller createSeller(CreateSellerRequest createSellerRequest) throws Exception {
        Optional<Seller> optionalSellerByName = getSeller.getSellerByName(createSellerRequest.name().trim());
        if(optionalSellerByName.isPresent()) throw new IllegalArgumentException(String.format("%s name exist with registered seller",createSellerRequest.name().trim()));
        Seller seller = sellerMapper.toSellerModel(createSellerRequest);
        return createSellerOutputPort.createSeller(seller);
    }
}
