package dev.julioperez.littleTree.operation.domain.model;

import dev.julioperez.littleTree.client.domain.model.ClientId;
import dev.julioperez.littleTree.operation.domain.enums.OperationType;

public final class Operation {

    private final OperationId id;
    private final OperationCreatedAt createdAt;
    private final ClientId clientId;
    private final OperationType operationType;

    public Operation(OperationId id, OperationCreatedAt createdAt, ClientId clientId, OperationType operationType) {
        this.id = id;
        this.createdAt = createdAt;
        this.clientId = clientId;
        this.operationType = operationType;
    }
}
