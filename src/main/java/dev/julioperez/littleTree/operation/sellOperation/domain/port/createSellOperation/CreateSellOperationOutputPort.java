package dev.julioperez.littleTree.operation.sellOperation.domain.port.createSellOperation;

import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;

import java.util.List;

public interface CreateSellOperationOutputPort {
    List<SellOperation> saveSellOperations(List<SellOperation> sellOperations);
}
