package dev.julioperez.littleTree.client.clientDifference.application.createClientDifference.delivery;

import dev.julioperez.littleTree.client.clientDifference.domain.dto.CreateClientDifferenceRequest;
import dev.julioperez.littleTree.client.clientDifference.domain.model.ClientDifference;
import dev.julioperez.littleTree.client.clientDifference.domain.port.createClientDifference.CreateClientDifference;
import dev.julioperez.littleTree.client.clientDifference.domain.port.createClientDifference.CreateClientDifferenceInputPort;

public class CreateClientDifferenceDelivery implements CreateClientDifferenceInputPort {

    private final CreateClientDifference clientDifference;

    public CreateClientDifferenceDelivery(CreateClientDifference clientDifference) {
        this.clientDifference = clientDifference;
    }

    @Override
    public ClientDifference createClientDifference(CreateClientDifferenceRequest createClientDifferenceRequest) throws Exception {
        return clientDifference.createClientDifference(createClientDifferenceRequest);
    }
}
