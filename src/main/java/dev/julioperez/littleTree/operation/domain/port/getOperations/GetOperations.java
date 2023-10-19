package dev.julioperez.littleTree.operation.domain.port.getOperations;

import dev.julioperez.littleTree.operation.domain.dto.GetBuyAndSellOperationResponseDto;
import dev.julioperez.littleTree.operation.domain.dto.GetOperationResponseDto;
import dev.julioperez.littleTree.operation.domain.dto.GetDoneOperationToShowReserve;
import dev.julioperez.littleTree.operation.domain.model.buyOperation.BuyOperation;
import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperation;

import java.util.List;
import java.util.Optional;

public interface GetOperations {
    List<BuyOperation> getBuyOperations();
    GetBuyAndSellOperationResponseDto getPendingBuyAndSellOperations();
    GetBuyAndSellOperationResponseDto getDoneBuyAndSellOperations();
    List<GetOperationResponseDto> getDoneBuyOperations();
    List<GetDoneOperationToShowReserve> getDoneBuyOperationsByCurrency(String currency);
    Optional<BuyOperation> getBuyOperationById(String operationId);
    List<SellOperation> getSellOperations();
    Optional<SellOperation> getSellOperationById(String operationId);
}
