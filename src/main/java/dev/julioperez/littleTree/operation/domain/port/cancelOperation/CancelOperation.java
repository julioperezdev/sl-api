package dev.julioperez.littleTree.operation.domain.port.cancelOperation;

public interface CancelOperation {
    boolean changePendingToCancelOperation(String operationId, String operationTypeValue);
}
