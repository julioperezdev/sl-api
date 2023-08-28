package dev.julioperez.littleTree.operation.domain.port.getOperations;

import dev.julioperez.littleTree.operation.domain.model.buyOperation.BuyOperation;
import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperation;

import java.util.List;
import java.util.Optional;

public interface GetOperations {
    List<BuyOperation> getBuyOperations();
    Optional<BuyOperation> getBuyOperationById(String operationId);
    List<SellOperation> getSellOperations();
    Optional<SellOperation> getSellOperationById(String operationId);
}
