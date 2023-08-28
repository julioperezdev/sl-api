package dev.julioperez.littleTree.operation.application.cancelOperation.delivery;

import dev.julioperez.littleTree.operation.domain.dto.ChangePendingOperationRequest;
import dev.julioperez.littleTree.operation.domain.port.cancelOperation.CancelOperation;
import dev.julioperez.littleTree.operation.domain.port.cancelOperation.CancelOperationInputPort;

public class CancelOperationDelivery implements CancelOperationInputPort {
    private final CancelOperation cancelOperation;

    public CancelOperationDelivery(CancelOperation cancelOperation) {
        this.cancelOperation = cancelOperation;
    }

    @Override
    public boolean changePendingToCancelOperation(ChangePendingOperationRequest changePendingOperationRequest) {
        return cancelOperation.changePendingToCancelOperation(changePendingOperationRequest.operationId(), changePendingOperationRequest.operationTypeValue());
    }
}
