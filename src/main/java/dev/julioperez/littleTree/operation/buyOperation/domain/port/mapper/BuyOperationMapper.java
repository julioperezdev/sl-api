package dev.julioperez.littleTree.operation.buyOperation.domain.port.mapper;

import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.buyOperation.infrastructure.repository.entity.BuyOperationEntity;

import java.util.List;

public interface BuyOperationMapper {
    List<BuyOperation> toBuyOperationsModel(List<BuyOperationEntity> buyOperationEntities);
    BuyOperation toBuyOperationModel(BuyOperationEntity buyOperation);
    BuyOperationEntity toBuyOperationEntity(BuyOperation buyOperation);
    List<BuyOperationEntity> toBuyOperationsEntity(List<BuyOperation> buyOperations);
}
