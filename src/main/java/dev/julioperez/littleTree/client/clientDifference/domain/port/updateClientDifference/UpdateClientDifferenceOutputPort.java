package dev.julioperez.littleTree.client.clientDifference.domain.port.updateClientDifference;

import dev.julioperez.littleTree.client.clientDifference.domain.model.ClientDifference;

public interface UpdateClientDifferenceOutputPort {
    ClientDifference updateClientDifference(ClientDifference clientDifference);

}
