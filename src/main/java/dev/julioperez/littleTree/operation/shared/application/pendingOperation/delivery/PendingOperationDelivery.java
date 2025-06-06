package dev.julioperez.littleTree.operation.shared.application.pendingOperation.delivery;

import dev.julioperez.littleTree.operation.shared.domain.dto.ChangePendingOperationRequest;
import dev.julioperez.littleTree.operation.shared.domain.port.pendingOperation.PendingOperation;
import dev.julioperez.littleTree.operation.shared.domain.port.pendingOperation.PendingOperationInputPort;

public class PendingOperationDelivery implements PendingOperationInputPort {
    private final PendingOperation pendingOperation;

    public PendingOperationDelivery(PendingOperation pendingOperation) {
        this.pendingOperation = pendingOperation;
    }

    @Override
    public boolean changePendingToExecuteOperation(ChangePendingOperationRequest changePendingOperationRequest) {
        return pendingOperation.changePendingToExecuteOperation(changePendingOperationRequest.operationId(), changePendingOperationRequest.operationTypeValue(), null);
    }
}
