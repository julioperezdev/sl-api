package dev.julioperez.littleTree.operation.domain.port.createOperation;

import dev.julioperez.littleTree.operation.domain.dto.BuyOperationRequest;
import dev.julioperez.littleTree.operation.domain.dto.SellOperationRequest;
import dev.julioperez.littleTree.operation.domain.model.operation.Operation;

public interface CreateOperationInputPort {
    boolean createBuyOperation(BuyOperationRequest buyOperationRequest);
    boolean createSellOperation(SellOperationRequest sellOperationRequest);
}
