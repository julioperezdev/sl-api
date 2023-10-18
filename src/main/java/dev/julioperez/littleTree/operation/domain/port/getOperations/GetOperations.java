package dev.julioperez.littleTree.operation.domain.port.getOperations;

import dev.julioperez.littleTree.operation.domain.dto.GetBuyOperationResponse;
import dev.julioperez.littleTree.operation.domain.dto.GetDoneOperationToShowReserve;
import dev.julioperez.littleTree.operation.domain.model.buyOperation.BuyOperation;
import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperation;

import java.util.List;
import java.util.Optional;

public interface GetOperations {
    List<BuyOperation> getBuyOperations();
    List<GetBuyOperationResponse> getPendingBuyOperations();
    List<GetBuyOperationResponse> getDoneBuyOperations();
    List<GetDoneOperationToShowReserve> getDoneBuyOperationsByCurrency(String currency);
    Optional<BuyOperation> getBuyOperationById(String operationId);
    List<SellOperation> getSellOperations();
    Optional<SellOperation> getSellOperationById(String operationId);
}
