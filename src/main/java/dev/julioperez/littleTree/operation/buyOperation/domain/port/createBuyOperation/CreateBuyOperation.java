package dev.julioperez.littleTree.operation.buyOperation.domain.port.createBuyOperation;

import dev.julioperez.littleTree.operation.buyOperation.domain.dto.BuyOperationRequest;

public interface CreateBuyOperation {
    boolean execute(BuyOperationRequest buyOperationRequest);
}
