package dev.julioperez.littleTree.operation.domain.port.executeSellOperation;

import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperation;

public interface ExecuteSellOperationOutputPort {
    SellOperation updateSellOperations(SellOperation sellOperation);
}
