package dev.julioperez.littleTree.operation.buyOperation.application.updateBuyOperation.service;

import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.buyOperation.domain.port.updateBuyOperation.UpdateBuyOperation;
import dev.julioperez.littleTree.operation.buyOperation.domain.port.updateBuyOperation.UpdateBuyOperationOutputPort;

import java.util.List;

public class UpdateBuyOperationService implements UpdateBuyOperation {
    private final UpdateBuyOperationOutputPort updateBuyOperationOutputPort;

    public UpdateBuyOperationService(UpdateBuyOperationOutputPort updateBuyOperationOutputPort) {
        this.updateBuyOperationOutputPort = updateBuyOperationOutputPort;
    }

    @Override
    public List<BuyOperation> execute(List<BuyOperation> buyOperations) {
        return updateBuyOperationOutputPort.updateBuyOperations(buyOperations);
    }
}
