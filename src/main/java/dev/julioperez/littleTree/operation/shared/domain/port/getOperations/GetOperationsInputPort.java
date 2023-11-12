package dev.julioperez.littleTree.operation.shared.domain.port.getOperations;

import dev.julioperez.littleTree.operation.shared.domain.dto.GetBuyAndSellOperationResponseDto;
import dev.julioperez.littleTree.operation.shared.domain.dto.GetOperationResponseDto;
import dev.julioperez.littleTree.operation.shared.domain.dto.GetDoneOperationToShowReserve;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;

import java.util.List;

public interface GetOperationsInputPort {
    List<BuyOperation> getBuyOperations();
    GetBuyAndSellOperationResponseDto getPendingBuyAndSellOperations();
    GetBuyAndSellOperationResponseDto getDoneBuyAndSellOperations();
    List<GetOperationResponseDto> getDoneBuyOperations();
    List<GetDoneOperationToShowReserve> getDoneBuyOperationsByCurrency(String currency);
    List<SellOperation> getSellOperations();
}
