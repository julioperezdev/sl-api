package dev.julioperez.littleTree.operation.domain.port.getOperations;

import dev.julioperez.littleTree.operation.domain.dto.GetBuyAndSellOperationResponseDto;
import dev.julioperez.littleTree.operation.domain.dto.GetOperationResponseDto;
import dev.julioperez.littleTree.operation.domain.dto.GetDoneOperationToShowReserve;
import dev.julioperez.littleTree.operation.domain.model.buyOperation.BuyOperation;
import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperation;

import java.util.List;

public interface GetOperationsInputPort {
    List<BuyOperation> getBuyOperations();
    GetBuyAndSellOperationResponseDto getPendingBuyAndSellOperations();
    GetBuyAndSellOperationResponseDto getDoneBuyAndSellOperations();
    List<GetOperationResponseDto> getDoneBuyOperations();
    List<GetDoneOperationToShowReserve> getDoneBuyOperationsByCurrency(String currency);
    List<SellOperation> getSellOperations();
}
