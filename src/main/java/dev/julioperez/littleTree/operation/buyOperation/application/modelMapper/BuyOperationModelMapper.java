package dev.julioperez.littleTree.operation.buyOperation.application.modelMapper;


import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.buyOperation.domain.port.mapper.BuyOperationMapper;
import dev.julioperez.littleTree.operation.buyOperation.infrastructure.repository.entity.BuyOperationEntity;

import java.util.List;

public class BuyOperationModelMapper implements BuyOperationMapper {

    @Override
    public List<BuyOperation> toBuyOperationsModel(List<BuyOperationEntity> buyOperationEntities) {
        return buyOperationEntities.stream()
                .map(this::toBuyOperationModel)
                .toList();
    }

    @Override
    public BuyOperation toBuyOperationModel(BuyOperationEntity buyOperationEntity) {
        return new BuyOperation(
                buyOperationEntity.getId(),
                buyOperationEntity.getCreatedAt(),
                buyOperationEntity.getUpdatedAt(),
                buyOperationEntity.getClientId(),
                buyOperationEntity.getCurrencyMultiBox(),
                buyOperationEntity.getPrice(),
                buyOperationEntity.getQuantity(),
                buyOperationEntity.getPercent(),
                buyOperationEntity.getTotal(),
                buyOperationEntity.getOfficeCheck(),
                buyOperationEntity.getOperationStatus(),
                buyOperationEntity.getReserve());
    }

    @Override
    public BuyOperationEntity toBuyOperationEntity(BuyOperation buyOperation) {
        return new BuyOperationEntity(
                buyOperation.getId(),
                buyOperation.getCreatedAt(),
                buyOperation.getUpdatedAt(),
                buyOperation.getClientId(),
                buyOperation.getCurrencyMultiBox(),
                buyOperation.getPrice(),
                buyOperation.getQuantity(),
                buyOperation.getPercent(),
                buyOperation.getTotal(),
                buyOperation.hasOfficeCheck(),
                buyOperation.getOperationStatus(),
                buyOperation.getReserve());
    }

    @Override
    public List<BuyOperationEntity> toBuyOperationsEntity(List<BuyOperation> buyOperations) {
        return buyOperations.stream()
                .map(this::toBuyOperationEntity)
                .toList();
    }
}
