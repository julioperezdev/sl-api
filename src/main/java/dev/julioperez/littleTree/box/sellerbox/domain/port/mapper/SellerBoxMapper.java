package dev.julioperez.littleTree.box.sellerbox.domain.port.mapper;

import dev.julioperez.littleTree.box.sellerbox.domain.model.SellerBox;
import dev.julioperez.littleTree.box.sellerbox.infrastructure.repository.entity.SellerBoxEntity;

import java.util.List;

public interface SellerBoxMapper {
    SellerBox toSellerBoxModel(SellerBoxEntity sellerBoxEntity);
    List<SellerBox> toSellerBoxesModel(List<SellerBoxEntity> sellerBoxEntities);
    SellerBoxEntity toSellerBoxEntity(SellerBox sellerBox);
}
