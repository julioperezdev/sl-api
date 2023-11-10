package dev.julioperez.littleTree.seller.seller.domain.port.mapper;

import dev.julioperez.littleTree.seller.seller.domain.dto.CreateSellerRequest;
import dev.julioperez.littleTree.seller.seller.domain.dto.UpdateSellerRequest;
import dev.julioperez.littleTree.seller.seller.domain.model.Seller;
import dev.julioperez.littleTree.seller.seller.infrastructure.repository.entity.SellerEntity;

import java.util.List;

public interface SellerMapper {
    Seller toSellerModel(CreateSellerRequest createSellerRequest) throws Exception;
    Seller toSellerModel(Seller seller, UpdateSellerRequest updateSellerRequest);
    Seller toSellerModel(SellerEntity sellerEntity);
    List<Seller> toSellersModel(List<SellerEntity> sellerEntities);
    SellerEntity toSellerEntity(Seller seller);
}
