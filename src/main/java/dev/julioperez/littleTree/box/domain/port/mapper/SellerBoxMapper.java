package dev.julioperez.littleTree.box.domain.port.mapper;

import dev.julioperez.littleTree.box.domain.model.Balance;
import dev.julioperez.littleTree.box.domain.model.SellerBox;
import dev.julioperez.littleTree.box.infrastructure.repository.entity.BalanceEntity;
import dev.julioperez.littleTree.box.infrastructure.repository.entity.SellerBoxEntity;

import java.util.List;

public interface SellerBoxMapper {
    SellerBox toSellerBoxModel(SellerBoxEntity sellerBoxEntity);
    List<SellerBox> toSellerBoxesModel(List<SellerBoxEntity> sellerBoxEntities);
    SellerBoxEntity toSellerBoxEntity(SellerBox sellerBox);
}
