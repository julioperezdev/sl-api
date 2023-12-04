package dev.julioperez.littleTree.operation.shared.domain.port.getOperations;

import dev.julioperez.littleTree.operation.shared.domain.dto.GetBuyAndSellOperationResponseDto;
import dev.julioperez.littleTree.operation.shared.domain.dto.GetOperationResponseDto;
import dev.julioperez.littleTree.operation.shared.domain.dto.GetDoneOperationToShowReserve;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;
import dev.julioperez.littleTree.operation.shared.domain.dto.TotalPendingOperationDto;

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
    TotalPendingOperationDto getTotalPendingOperationDto();
}
