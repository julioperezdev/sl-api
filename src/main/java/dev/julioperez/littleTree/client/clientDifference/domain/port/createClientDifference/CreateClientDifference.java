package dev.julioperez.littleTree.client.clientDifference.domain.port.createClientDifference;

import dev.julioperez.littleTree.client.clientDifference.domain.dto.CreateClientDifferenceRequest;
import dev.julioperez.littleTree.client.clientDifference.domain.model.ClientDifference;

public interface CreateClientDifference {
    ClientDifference createClientDifference(CreateClientDifferenceRequest createClientDifferenceRequest) throws Exception;
}
