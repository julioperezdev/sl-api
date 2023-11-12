package dev.julioperez.littleTree.operation.shared.domain.port.cancelOperation;

public interface CancelOperation {
    boolean changePendingToCancelOperation(String operationId, String operationTypeValue);
}
