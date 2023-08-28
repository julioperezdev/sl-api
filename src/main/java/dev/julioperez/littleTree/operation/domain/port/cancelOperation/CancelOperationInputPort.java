package dev.julioperez.littleTree.operation.domain.port.cancelOperation;

import dev.julioperez.littleTree.operation.domain.dto.ChangePendingOperationRequest;

public interface CancelOperationInputPort {
    boolean changePendingToCancelOperation(ChangePendingOperationRequest changePendingOperationRequest);
}
