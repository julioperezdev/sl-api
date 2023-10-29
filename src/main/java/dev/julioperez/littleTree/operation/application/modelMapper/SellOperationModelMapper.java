package dev.julioperez.littleTree.operation.application.modelMapper;

import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperation;
import dev.julioperez.littleTree.operation.domain.port.mapper.SellOperationMapper;
import dev.julioperez.littleTree.operation.infrastructure.repository.entity.SellOperationEntity;

import java.util.List;

public class SellOperationModelMapper implements SellOperationMapper {
    @Override
    public SellOperation toSellOperationModel(SellOperationEntity sellOperationEntity) {
        return new SellOperation(
                sellOperationEntity.getId(),
                sellOperationEntity.getCreatedAt(),
                sellOperationEntity.getUpdatedAt(),
                sellOperationEntity.getClientId(),
                sellOperationEntity.getCurrencyMultiBox(),
                sellOperationEntity.getPrice(),
                sellOperationEntity.getQuantity(),
                sellOperationEntity.getSubProfit(),
                sellOperationEntity.getProfit(),
                sellOperationEntity.getTotal(),
                sellOperationEntity.getSellerId(),
                sellOperationEntity.getOperationStatus(),
                sellOperationEntity.getSellerProfit());
    }

    @Override
    public List<SellOperation> toSellOperationsModel(List<SellOperationEntity> sellOperationEntities) {
        return sellOperationEntities.stream()
                .map(this::toSellOperationModel)
                .toList();
    }

    @Override
    public SellOperationEntity toSellOperationEntity(SellOperation sellOperation) {
        return new SellOperationEntity(
                sellOperation.getId(),
                sellOperation.getCreatedAt(),
                sellOperation.getUpdatedAt(),
                sellOperation.getClientId(),
                sellOperation.getCurrencyMultiBox(),
                sellOperation.getPrice(),
                sellOperation.getQuantity(),
                sellOperation.getSubProfit(),
                sellOperation.getProfit(),
                sellOperation.getTotal(),
                sellOperation.getSellerId(),
                sellOperation.getOperationStatus(),
                sellOperation.getSellerProfit());
    }

    @Override
    public List<SellOperationEntity> toSellOperationsEntity(List<SellOperation> sellOperations) {
        return sellOperations.stream()
                .map(this::toSellOperationEntity)
                .toList();
    }
}
