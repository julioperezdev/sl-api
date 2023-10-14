package dev.julioperez.littleTree.operation.domain.port.getOperations;

import dev.julioperez.littleTree.operation.domain.dto.GetBuyOperationResponse;
import dev.julioperez.littleTree.operation.domain.model.buyOperation.BuyOperation;
import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperation;

import java.util.List;

public interface GetOperationsInputPort {
    List<BuyOperation> getBuyOperations();
    List<GetBuyOperationResponse> getPendingBuyOperations();
    List<SellOperation> getSellOperations();
}
