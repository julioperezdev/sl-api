package dev.julioperez.littleTree.operation.domain.port.cancelOperation;

import dev.julioperez.littleTree.operation.domain.model.buyOperation.BuyOperation;
import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperation;

public interface CancelOperationOutputPort {
    BuyOperation updateBuyOperation(BuyOperation buyOperation);
    SellOperation updateSellOperations(SellOperation sellOperation);
}
