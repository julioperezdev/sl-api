package dev.julioperez.littleTree.operation.domain.port.executeBuyOperation;

import dev.julioperez.littleTree.operation.domain.model.buyOperation.BuyOperation;

public interface ExecuteBuyOperationOutputPort {
    BuyOperation updateBuyOperation(BuyOperation buyOperation);
}
