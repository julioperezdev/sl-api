package dev.julioperez.littleTree.operation.application.getOperations.delivery;

import dev.julioperez.littleTree.operation.domain.dto.GetBuyOperationResponse;
import dev.julioperez.littleTree.operation.domain.model.buyOperation.BuyOperation;
import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperation;
import dev.julioperez.littleTree.operation.domain.port.getOperations.GetOperations;
import dev.julioperez.littleTree.operation.domain.port.getOperations.GetOperationsInputPort;

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
    public List<GetBuyOperationResponse> getPendingBuyOperations() {
        return getOperations.getPendingBuyOperations();
    }

    @Override
    public List<SellOperation> getSellOperations() {
        return getOperations.getSellOperations();
    }
}
