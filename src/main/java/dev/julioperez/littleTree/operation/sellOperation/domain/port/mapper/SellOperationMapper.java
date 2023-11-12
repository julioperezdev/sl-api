package dev.julioperez.littleTree.operation.sellOperation.domain.port.mapper;


import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;
import dev.julioperez.littleTree.operation.sellOperation.infrastructure.repository.entity.SellOperationEntity;

import java.util.List;

public interface SellOperationMapper {
    SellOperation toSellOperationModel(SellOperationEntity sellOperationEntity);
    List<SellOperation> toSellOperationsModel(List<SellOperationEntity> sellOperationEntities);
    SellOperationEntity toSellOperationEntity(SellOperation sellOperation);
    List<SellOperationEntity> toSellOperationsEntity(List<SellOperation> sellOperations);
}
