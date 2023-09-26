package dev.julioperez.littleTree.seller.application.updateSeller.service;

import dev.julioperez.littleTree.seller.domain.dto.UpdateSellerRequest;
import dev.julioperez.littleTree.seller.domain.model.Seller;
import dev.julioperez.littleTree.seller.domain.port.getSeller.GetSeller;
import dev.julioperez.littleTree.seller.domain.port.mapper.SellerMapper;
import dev.julioperez.littleTree.seller.domain.port.updateSeller.UpdateSeller;
import dev.julioperez.littleTree.seller.domain.port.updateSeller.UpdateSellerOutputPort;

import java.util.Optional;

public class UpdateSellerService implements UpdateSeller {
    private final UpdateSellerOutputPort updateSellerOutputPort;
    private final GetSeller getSeller;
    private final SellerMapper sellerMapper;

    public UpdateSellerService(UpdateSellerOutputPort updateSellerOutputPort, GetSeller getSeller, SellerMapper sellerMapper) {
        this.updateSellerOutputPort = updateSellerOutputPort;
        this.getSeller = getSeller;
        this.sellerMapper = sellerMapper;
    }

    @Override
    public Seller updateSeller(UpdateSellerRequest updateSellerRequest) {
        Optional<Seller> sellerById = getSeller.getSellerById(updateSellerRequest.id());
        if(sellerById.isEmpty()) throw new IllegalArgumentException(String.format("%s value dont exist as Seller", updateSellerRequest.id()));
        Seller seller = sellerMapper.toSellerModel(sellerById.get(), updateSellerRequest);
        return updateSellerOutputPort.updateSeller(seller);
    }
}
