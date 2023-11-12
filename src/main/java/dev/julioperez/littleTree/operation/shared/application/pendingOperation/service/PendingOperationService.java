package dev.julioperez.littleTree.operation.shared.application.pendingOperation.service;

import dev.julioperez.littleTree.operation.shared.domain.enums.OperationType;
import dev.julioperez.littleTree.operation.buyOperation.domain.port.executeBuyOperation.ExecuteBuyOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.port.executeSellOperation.ExecuteSellOperation;
import dev.julioperez.littleTree.operation.shared.domain.port.pendingOperation.PendingOperation;
import dev.julioperez.littleTree.seller.sellerCommission.domain.dto.CreateSellerCommissionRequest;

public class PendingOperationService implements PendingOperation {

    private final ExecuteBuyOperation executeBuyOperation;
    private final ExecuteSellOperation executeSellOperation;

    public PendingOperationService(ExecuteBuyOperation executeBuyOperation, ExecuteSellOperation executeSellOperation) {
        this.executeBuyOperation = executeBuyOperation;
        this.executeSellOperation = executeSellOperation;
    }

    @Override
    public boolean changePendingToExecuteOperation(String operationId, String operationTypeValue, CreateSellerCommissionRequest createSellerCommissionRequest) {
        OperationType operationType = OperationType.returnOperationTypeByDescription(operationTypeValue);
        return operationType.isBuyOperation()
                ? executeBuyOperation.executeBuyOperation(operationId)
                : executeSellOperation.executeSellOperation(operationId, createSellerCommissionRequest);
    }
}
