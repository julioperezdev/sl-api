package dev.julioperez.littleTree.client.domain.port.updateClientDifference;

import dev.julioperez.littleTree.client.domain.model.ClientDifference;

public interface UpdateClientDifferenceOutputPort {
    ClientDifference updateClientDifference(ClientDifference clientDifference);

}
