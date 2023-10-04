package dev.julioperez.littleTree.operation.domain.port.mapper;

import dev.julioperez.littleTree.operation.domain.model.buyOperation.BuyOperation;
import dev.julioperez.littleTree.operation.infrastructure.repository.entity.BuyOperationEntity;

import java.util.List;

public interface BuyOperationMapper {
    List<BuyOperation> toBuyOperationsModel(List<BuyOperationEntity> buyOperationEntities);
    BuyOperation toBuyOperationModel(BuyOperationEntity buyOperation);
    BuyOperationEntity toBuyOperationEntity(BuyOperation buyOperation);
    List<BuyOperationEntity> toBuyOperationsEntity(List<BuyOperation> buyOperations);
}
