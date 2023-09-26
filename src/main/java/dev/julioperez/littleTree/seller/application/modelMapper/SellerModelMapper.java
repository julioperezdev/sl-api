package dev.julioperez.littleTree.seller.application.modelMapper;

import dev.julioperez.littleTree.seller.domain.dto.CreateSellerRequest;
import dev.julioperez.littleTree.seller.domain.dto.UpdateSellerRequest;
import dev.julioperez.littleTree.seller.domain.model.Seller;
import dev.julioperez.littleTree.seller.domain.port.mapper.SellerMapper;
import dev.julioperez.littleTree.seller.infrastructure.repository.entity.SellerEntity;

import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class SellerModelMapper implements SellerMapper {
        @Override
        public Seller toSellerModel(CreateSellerRequest createSellerRequest) throws Exception{
                return new Seller(
                        //UUID.randomUUID().toString(),
                        createSellerRequest.id(),
                        createSellerRequest.name(),
                        createSellerRequest.phone(),
                        Date.from(Instant.now()));
        }

        @Override
        public Seller toSellerModel(Seller seller, UpdateSellerRequest updateSellerRequest){
                return new Seller(
                        seller.getId(),
                        seller.getName(),
                        updateSellerRequest.phone(),
                        seller.getCreatedAt());
        }

        @Override
        public Seller toSellerModel(SellerEntity sellerEntity) {
                return new Seller(
                        sellerEntity.getId(),
                        sellerEntity.getName(),
                        sellerEntity.getPhone(),
                        sellerEntity.getCreatedAt());
        }

        @Override
        public List<Seller> toSellersModel(List<SellerEntity> sellerEntities) {
                return sellerEntities.stream().map(this::toSellerModel).toList();
        }

        @Override
        public SellerEntity toSellerEntity(Seller seller) {
                return new SellerEntity(
                        seller.getId(),
                        seller.getName(),
                        seller.getPhone(),
                        seller.getCreatedAt());
        }
}
