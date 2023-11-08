package dev.julioperez.littleTree.box.sellerbox.application.modelMapper;

import dev.julioperez.littleTree.box.sellerbox.domain.model.SellerBox;
import dev.julioperez.littleTree.box.sellerbox.domain.port.mapper.SellerBoxMapper;
import dev.julioperez.littleTree.box.sellerbox.infrastructure.repository.entity.SellerBoxEntity;

import java.util.List;

public class SellerBoxModelMapper implements SellerBoxMapper {
    @Override
    public SellerBox toSellerBoxModel(SellerBoxEntity sellerBoxEntity) {
        return new SellerBox(
                sellerBoxEntity.getId(),
                sellerBoxEntity.getQuantity(),
                sellerBoxEntity.getQuantityOperation(),
                sellerBoxEntity.getName(),
                sellerBoxEntity.getOperationType(),
                sellerBoxEntity.getCreatedAt(),
                sellerBoxEntity.getUpdatedAt());
    }

    @Override
    public List<SellerBox> toSellerBoxesModel(List<SellerBoxEntity> sellerBoxEntities) {
        return sellerBoxEntities.stream()
                .map(this::toSellerBoxModel)
                .toList();
    }

    @Override
    public SellerBoxEntity toSellerBoxEntity(SellerBox sellerBox) {
        return new SellerBoxEntity(
                sellerBox.getId(),
                sellerBox.getQuantity(),
                sellerBox.getQuantityOperation(),
                sellerBox.getName(),
                sellerBox.getOperationType(),
                sellerBox.getCreatedAt(),
                sellerBox.getUpdatedAt());
    }
}
