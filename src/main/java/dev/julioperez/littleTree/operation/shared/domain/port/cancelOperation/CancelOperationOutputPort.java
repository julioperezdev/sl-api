package dev.julioperez.littleTree.operation.shared.domain.port.cancelOperation;

import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;

public interface CancelOperationOutputPort {
    BuyOperation updateBuyOperation(BuyOperation buyOperation);
    SellOperation updateSellOperations(SellOperation sellOperation);
}
