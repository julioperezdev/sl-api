package dev.julioperez.littleTree.operation.application.getOperations.service;

import dev.julioperez.littleTree.operation.domain.model.buyOperation.BuyOperation;
import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperation;
import dev.julioperez.littleTree.operation.domain.port.getOperations.GetOperations;
import dev.julioperez.littleTree.operation.domain.port.getOperations.GetOperationsOutputPort;

import java.util.List;
import java.util.Optional;

public class GetOperationsService implements GetOperations {
    private final GetOperationsOutputPort getOperationsOutputPort;

    public GetOperationsService(GetOperationsOutputPort getOperationsOutputPort) {
        this.getOperationsOutputPort = getOperationsOutputPort;
    }

    @Override
    public List<BuyOperation> getBuyOperations() {
        return getOperationsOutputPort.getBuyOperations();
    }

    @Override
    public List<BuyOperation> getPendingBuyOperations() {
        return getOperationsOutputPort.getPendingBuyOperations();
    }

    @Override
    public Optional<BuyOperation> getBuyOperationById(String operationId) {
        return getBuyOperations().stream()
                .filter(operation -> operation.getId().equals(operationId))
                .findFirst();
    }

    @Override
    public List<SellOperation> getSellOperations() {
        return getOperationsOutputPort.getSellOperations();
    }

    @Override
    public Optional<SellOperation> getSellOperationById(String operationId) {
        return getSellOperations().stream()
                .filter(operation -> operation.getId().equals(operationId))
                .findFirst();
    }
}
