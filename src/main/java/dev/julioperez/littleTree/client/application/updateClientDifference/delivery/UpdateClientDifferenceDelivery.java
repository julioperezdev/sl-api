package dev.julioperez.littleTree.client.application.updateClientDifference.delivery;

import dev.julioperez.littleTree.client.domain.dto.UpdateClientDifferenceRequest;
import dev.julioperez.littleTree.client.domain.model.ClientDifference;
import dev.julioperez.littleTree.client.domain.port.updateClientDifference.UpdateClientDifference;
import dev.julioperez.littleTree.client.domain.port.updateClientDifference.UpdateClientDifferenceInputPort;

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
