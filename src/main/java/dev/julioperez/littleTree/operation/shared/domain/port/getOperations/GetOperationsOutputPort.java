package dev.julioperez.littleTree.operation.shared.domain.port.getOperations;

import dev.julioperez.littleTree.operation.shared.domain.enums.OperationStatus;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;

import java.util.List;

public interface GetOperationsOutputPort {
    List<BuyOperation> getBuyOperations();
    List<BuyOperation> getBuyOperationsByStatus(OperationStatus operationStatus);
    List<SellOperation> geSellOperationsByStatus(OperationStatus operationStatus);
    List<BuyOperation> getDoneBuyOperations();
    List<SellOperation> getSellOperations();
}
