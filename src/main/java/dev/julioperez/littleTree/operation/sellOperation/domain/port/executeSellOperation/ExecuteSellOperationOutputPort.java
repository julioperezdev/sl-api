package dev.julioperez.littleTree.operation.sellOperation.domain.port.executeSellOperation;

import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;

public interface ExecuteSellOperationOutputPort {
    SellOperation updateSellOperations(SellOperation sellOperation);
}
