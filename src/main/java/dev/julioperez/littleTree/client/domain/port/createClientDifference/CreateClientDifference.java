package dev.julioperez.littleTree.client.domain.port.createClientDifference;

import dev.julioperez.littleTree.client.domain.dto.CreateClientDifferenceRequest;
import dev.julioperez.littleTree.client.domain.model.ClientDifference;

public interface CreateClientDifference {
    ClientDifference createClientDifference(CreateClientDifferenceRequest createClientDifferenceRequest) throws Exception;
}
