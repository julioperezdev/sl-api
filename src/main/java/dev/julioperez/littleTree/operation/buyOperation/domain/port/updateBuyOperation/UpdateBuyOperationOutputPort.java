package dev.julioperez.littleTree.operation.buyOperation.domain.port.updateBuyOperation;

import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;

import java.util.List;

public interface UpdateBuyOperationOutputPort {
    List<BuyOperation> updateBuyOperations(List<BuyOperation> buyOperations);
}
