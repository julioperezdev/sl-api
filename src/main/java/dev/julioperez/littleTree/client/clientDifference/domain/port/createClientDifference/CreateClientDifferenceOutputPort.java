package dev.julioperez.littleTree.client.clientDifference.domain.port.createClientDifference;

import dev.julioperez.littleTree.client.clientDifference.domain.model.ClientDifference;

public interface CreateClientDifferenceOutputPort {
    ClientDifference createClientDifference(ClientDifference clientDifference) throws Exception;
}
