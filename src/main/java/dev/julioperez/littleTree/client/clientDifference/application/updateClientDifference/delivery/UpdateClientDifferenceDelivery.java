package dev.julioperez.littleTree.client.clientDifference.application.updateClientDifference.delivery;

import dev.julioperez.littleTree.client.clientDifference.domain.dto.UpdateClientDifferenceRequest;
import dev.julioperez.littleTree.client.clientDifference.domain.model.ClientDifference;
import dev.julioperez.littleTree.client.clientDifference.domain.port.updateClientDifference.UpdateClientDifference;
import dev.julioperez.littleTree.client.clientDifference.domain.port.updateClientDifference.UpdateClientDifferenceInputPort;

public class UpdateClientDifferenceDelivery implements UpdateClientDifferenceInputPort {

    private final UpdateClientDifference updateClientDifference;

    public UpdateClientDifferenceDelivery(UpdateClientDifference updateClientDifference) {
        this.updateClientDifference = updateClientDifference;
    }

    @Override
    public ClientDifference updateClientDifference(UpdateClientDifferenceRequest updateClientDifferenceRequest) {
        return updateClientDifference.updateClientDifference(updateClientDifferenceRequest);
    }
}
