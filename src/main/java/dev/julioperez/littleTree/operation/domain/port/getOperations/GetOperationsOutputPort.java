package dev.julioperez.littleTree.operation.domain.port.getOperations;

import dev.julioperez.littleTree.operation.domain.model.buyOperation.BuyOperation;
import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperation;

import java.util.List;

public interface GetOperationsOutputPort {
    List<BuyOperation> getBuyOperations();
    List<BuyOperation> getPendingBuyOperations();
    List<BuyOperation> getDoneBuyOperations();
    List<SellOperation> getSellOperations();
}
