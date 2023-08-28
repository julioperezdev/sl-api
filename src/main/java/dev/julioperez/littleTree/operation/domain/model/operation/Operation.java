package dev.julioperez.littleTree.operation.domain.model.operation;

import dev.julioperez.littleTree.client.domain.model.ClientId;
import dev.julioperez.littleTree.operation.domain.enums.OperationType;

import java.util.Date;

public final class Operation {

    private final OperationId id;
    private final OperationCreatedAt createdAt;
    private final ClientId clientId;
    private final OperationType operationType;

    public Operation(String id, Date createdAt, String clientId, String operationType) {
        this.id = new OperationId(id);
        this.createdAt = new OperationCreatedAt(createdAt);
        this.clientId = new ClientId(clientId);
        this.operationType = OperationType.returnOperationTypeByDescription(operationType);
    }

    public String getId() {
        return id.value();
    }

    public Date getCreatedAt() {
        return createdAt.value();
    }

    public String getClientId() {
        return clientId.value();
    }

    public String getOperationType() {
        return operationType.value();
    }
}
