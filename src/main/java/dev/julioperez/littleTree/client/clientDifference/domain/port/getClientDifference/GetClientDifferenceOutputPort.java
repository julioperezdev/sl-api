package dev.julioperez.littleTree.client.clientDifference.domain.port.getClientDifference;

import dev.julioperez.littleTree.client.clientDifference.domain.model.ClientDifference;

import java.util.List;

public interface GetClientDifferenceOutputPort {
    List<ClientDifference> getClientDifference();
}
