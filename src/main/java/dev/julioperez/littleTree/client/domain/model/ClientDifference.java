package dev.julioperez.littleTree.client.domain.model;

import dev.julioperez.littleTree.client.domain.enums.DifferenceStatus;
import dev.julioperez.littleTree.client.domain.enums.DifferenceType;


public final class ClientDifference {

    private final ClientDifferenceId id;
    private final ClientDifferenceCreatedAt createdAt;
    private final ClientId clientId;
    private final ClientDifferenceAmount amount;
    private final ClientDifferenceDescription description;
    private final DifferenceType differenceType;
    private final DifferenceStatus differenceStatus;

    public ClientDifference(ClientDifferenceId id, ClientDifferenceCreatedAt createdAt, ClientId clientId, ClientDifferenceAmount amount, ClientDifferenceDescription description, DifferenceType differenceType, DifferenceStatus differenceStatus) {
        this.id = id;
        this.createdAt = createdAt;
        this.clientId = clientId;
        this.amount = amount;
        this.description = description;
        this.differenceType = differenceType;
        this.differenceStatus = differenceStatus;
    }
}
