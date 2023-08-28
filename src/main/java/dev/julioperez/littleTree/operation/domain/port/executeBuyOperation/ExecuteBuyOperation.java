package dev.julioperez.littleTree.operation.domain.port.executeBuyOperation;

import dev.julioperez.littleTree.operation.domain.model.operation.Operation;

public interface ExecuteBuyOperation {
    boolean executeBuyOperation(String operationId);
}
