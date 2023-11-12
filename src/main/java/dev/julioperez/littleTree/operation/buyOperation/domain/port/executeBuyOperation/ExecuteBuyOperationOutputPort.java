package dev.julioperez.littleTree.operation.buyOperation.domain.port.executeBuyOperation;

import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;

public interface ExecuteBuyOperationOutputPort {
    BuyOperation updateBuyOperation(BuyOperation buyOperation);
}
