package dev.julioperez.littleTree.client.application.createClientDifference.delivery;

import dev.julioperez.littleTree.client.domain.dto.CreateClientDifferenceRequest;
import dev.julioperez.littleTree.client.domain.model.ClientDifference;
import dev.julioperez.littleTree.client.domain.port.createClientDifference.CreateClientDifference;
import dev.julioperez.littleTree.client.domain.port.createClientDifference.CreateClientDifferenceInputPort;

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
