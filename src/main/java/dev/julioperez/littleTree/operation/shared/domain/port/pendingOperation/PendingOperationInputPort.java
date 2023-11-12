package dev.julioperez.littleTree.operation.shared.domain.port.pendingOperation;

import dev.julioperez.littleTree.operation.shared.domain.dto.ChangePendingOperationRequest;

public interface PendingOperationInputPort {
    boolean changePendingToExecuteOperation(ChangePendingOperationRequest changePendingOperationRequest);
}
