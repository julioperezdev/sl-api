package dev.julioperez.littleTree.operation.shared.domain.port.createOperation;

import dev.julioperez.littleTree.operation.buyOperation.domain.dto.BuyOperationRequest;
import dev.julioperez.littleTree.operation.sellOperation.domain.dto.SellOperationRequest;

public interface CreateOperationInputPort {
    boolean createBuyOperation(BuyOperationRequest buyOperationRequest);
    boolean createSellOperation(SellOperationRequest sellOperationRequest);
}
