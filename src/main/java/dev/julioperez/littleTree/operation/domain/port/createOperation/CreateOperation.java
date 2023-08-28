package dev.julioperez.littleTree.operation.domain.port.createOperation;

import dev.julioperez.littleTree.operation.domain.dto.BuyOperationRequest;
import dev.julioperez.littleTree.operation.domain.dto.CreateOperationRequest;
import dev.julioperez.littleTree.operation.domain.dto.SellOperationRequest;
import dev.julioperez.littleTree.operation.domain.model.operation.Operation;

public interface CreateOperation {
    boolean createBuyOperationToBePending(BuyOperationRequest buyOperationRequest);
    boolean createSellOperationToBePending(SellOperationRequest sellOperationRequest);
}
