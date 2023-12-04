package dev.julioperez.littleTree.operation.shared.application.getOperations.delivery;

import dev.julioperez.littleTree.operation.shared.domain.dto.GetBuyAndSellOperationResponseDto;
import dev.julioperez.littleTree.operation.shared.domain.dto.GetOperationResponseDto;
import dev.julioperez.littleTree.operation.shared.domain.dto.GetDoneOperationToShowReserve;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;
import dev.julioperez.littleTree.operation.shared.domain.dto.TotalPendingOperationDto;
import dev.julioperez.littleTree.operation.shared.domain.port.getOperations.GetOperations;
import dev.julioperez.littleTree.operation.shared.domain.port.getOperations.GetOperationsInputPort;

import java.util.List;

public class GetOperationsDelivery implements GetOperationsInputPort {
    private final GetOperations getOperations;

    public GetOperationsDelivery(GetOperations getOperations) {
        this.getOperations = getOperations;
    }

    @Override
    public List<BuyOperation> getBuyOperations() {
        return getOperations.getBuyOperations();
    }

    @Override
    public GetBuyAndSellOperationResponseDto getPendingBuyAndSellOperations() {
        return getOperations.getPendingBuyAndSellOperations();
    }

    @Override
    public GetBuyAndSellOperationResponseDto getDoneBuyAndSellOperations() {
        return getOperations.getDoneBuyAndSellOperations();
    }

    @Override
    public List<GetOperationResponseDto> getDoneBuyOperations() {
        return getOperations.getDoneBuyOperations();
    }

    @Override
    public List<GetDoneOperationToShowReserve> getDoneBuyOperationsByCurrency(String currency) {
        return getOperations.getDoneBuyOperationsByCurrency(currency);
    }

    @Override
    public List<SellOperation> getSellOperations() {
        return getOperations.getSellOperations();
    }

    @Override
    public TotalPendingOperationDto getTotalPendingOperationDto() {
        return getOperations.getTotalPendingOperationDto();
    }
}
