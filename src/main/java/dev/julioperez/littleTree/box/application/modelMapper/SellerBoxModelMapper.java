package dev.julioperez.littleTree.box.application.modelMapper;

import dev.julioperez.littleTree.box.domain.model.SellerBox;
import dev.julioperez.littleTree.box.domain.port.mapper.SellerBoxMapper;
import dev.julioperez.littleTree.box.infrastructure.repository.entity.SellerBoxEntity;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class SellerBoxModelMapper implements SellerBoxMapper {
    @Override
    public SellerBox toSellerBoxModel(SellerBoxEntity sellerBoxEntity) {
        return new SellerBox(
                sellerBoxEntity.getId(),

                sellerBoxEntity.getBalanceId(),
                sellerBoxEntity.getName(),
                sellerBoxEntity.getDescription(),
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
                sellerBox.getBalanceId(),
                sellerBox.getName(),
                sellerBox.getDescription(),
                sellerBox.getCreatedAt(),
                sellerBox.getUpdatedAt());
    }
}
