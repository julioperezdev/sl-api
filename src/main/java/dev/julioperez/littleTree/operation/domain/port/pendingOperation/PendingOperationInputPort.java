package dev.julioperez.littleTree.operation.domain.port.pendingOperation;

import dev.julioperez.littleTree.operation.domain.dto.ChangePendingOperationRequest;

public interface PendingOperationInputPort {
    boolean changePendingToExecuteOperation(ChangePendingOperationRequest changePendingOperationRequest);
}
