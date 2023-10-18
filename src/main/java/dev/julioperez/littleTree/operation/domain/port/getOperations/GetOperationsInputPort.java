package dev.julioperez.littleTree.operation.domain.port.getOperations;

import dev.julioperez.littleTree.operation.domain.dto.GetBuyOperationResponse;
import dev.julioperez.littleTree.operation.domain.dto.GetDoneOperationToShowReserve;
import dev.julioperez.littleTree.operation.domain.model.buyOperation.BuyOperation;
import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperation;

import java.util.List;

public interface GetOperationsInputPort {
    List<BuyOperation> getBuyOperations();
    List<GetBuyOperationResponse> getPendingBuyOperations();
    List<GetBuyOperationResponse> getDoneBuyOperations();
    List<GetDoneOperationToShowReserve> getDoneBuyOperationsByCurrency(String currency);
    List<SellOperation> getSellOperations();
}
