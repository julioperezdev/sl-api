package dev.julioperez.littleTree.operation.sellOperation.domain.port.createSellOperation;

import dev.julioperez.littleTree.operation.sellOperation.domain.dto.SellOperationRequest;

public interface CreateSellOperationInputPort {
    boolean createSellOperation(SellOperationRequest sellOperationRequest);
}
