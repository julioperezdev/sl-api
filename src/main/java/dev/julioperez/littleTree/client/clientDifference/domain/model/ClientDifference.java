package dev.julioperez.littleTree.client.clientDifference.domain.model;

import dev.julioperez.littleTree.client.clientDifference.domain.enums.DifferenceStatus;
import dev.julioperez.littleTree.client.clientDifference.domain.enums.DifferenceType;
import dev.julioperez.littleTree.client.client.domain.model.ClientId;

import java.util.Date;


public final class ClientDifference {

    private final ClientDifferenceId id;
    private final ClientDifferenceCreatedAt createdAt;
    private final ClientDifferenceUpdatedAt updatedAt;
    private final ClientId clientId;
    private final ClientDifferenceAmount amount;
    private final ClientDifferenceDescription description;
    private final DifferenceType differenceType;
    private final DifferenceStatus differenceStatus;

    public ClientDifference(String id, Date createdAt,Date updatedAt, String clientId, Float amount, String description, String differenceType, String differenceStatus) {
        this.id = new ClientDifferenceId(id);
        this.createdAt = new ClientDifferenceCreatedAt(createdAt);
        this.clientId = new ClientId(clientId);
        this.amount = new ClientDifferenceAmount(amount);
        this.description = new ClientDifferenceDescription(description);
        this.differenceType = DifferenceType.returnDifferenceTypeByDescription(differenceType);
        this.differenceStatus = DifferenceStatus.returnDifferenceStatusByDescription(differenceStatus);
        this.updatedAt = new ClientDifferenceUpdatedAt(updatedAt);
    }

    public String getId() {
        return id.value();
    }
    public Date getCreatedAt() {
        return createdAt.value();
    }
    public Date getUpdatedAt() {
        return updatedAt.value();
    }

    public String getClientId() {
        return clientId.value();
    }

    public Float getAmount() {
        return amount.value();
    }

    public String getDescription() {
        return description.value();
    }
    public String getDifferenceType() {
        return differenceType.value();
    }
    public String getDifferenceStatus() {
        return differenceStatus.value();
    }




}
