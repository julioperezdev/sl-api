package dev.julioperez.littleTree.operation.shared.domain.port.cancelOperation;

import dev.julioperez.littleTree.operation.shared.domain.dto.ChangePendingOperationRequest;

public interface CancelOperationInputPort {
    boolean changePendingToCancelOperation(ChangePendingOperationRequest changePendingOperationRequest);
}
