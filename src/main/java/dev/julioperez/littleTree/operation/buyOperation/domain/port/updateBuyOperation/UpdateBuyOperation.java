package dev.julioperez.littleTree.operation.buyOperation.domain.port.updateBuyOperation;

import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;

import java.util.List;

public interface UpdateBuyOperation {
    List<BuyOperation> execute(List<BuyOperation> buyOperations);
}
