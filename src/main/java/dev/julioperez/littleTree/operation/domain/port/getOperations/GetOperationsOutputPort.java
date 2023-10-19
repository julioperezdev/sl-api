package dev.julioperez.littleTree.operation.domain.port.getOperations;

import dev.julioperez.littleTree.operation.domain.enums.OperationStatus;
import dev.julioperez.littleTree.operation.domain.model.buyOperation.BuyOperation;
import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperation;

import java.util.List;

public interface GetOperationsOutputPort {
    List<BuyOperation> getBuyOperations();
    List<BuyOperation> getBuyOperationsByStatus(OperationStatus operationStatus);
    List<SellOperation> geSellOperationsByStatus(OperationStatus operationStatus);
    List<BuyOperation> getDoneBuyOperations();
    List<SellOperation> getSellOperations();
}
