package dev.julioperez.littleTree.operation.shared.domain.port.createOperation;

import dev.julioperez.littleTree.operation.buyOperation.domain.dto.BuyOperationRequest;
import dev.julioperez.littleTree.operation.sellOperation.domain.dto.SellOperationRequest;

public interface CreateOperation {
    boolean createBuyOperationToBePending(BuyOperationRequest buyOperationRequest);
    boolean createSellOperationToBePending(SellOperationRequest sellOperationRequest);
}
