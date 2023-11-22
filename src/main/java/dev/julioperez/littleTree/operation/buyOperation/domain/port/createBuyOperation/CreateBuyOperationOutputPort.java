package dev.julioperez.littleTree.operation.buyOperation.domain.port.createBuyOperation;

import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;

import java.util.List;

public interface CreateBuyOperationOutputPort {
    List<BuyOperation> saveBuyOperations(List<BuyOperation> buyOperations);
}
