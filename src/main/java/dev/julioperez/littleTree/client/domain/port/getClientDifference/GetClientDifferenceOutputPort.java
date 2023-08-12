package dev.julioperez.littleTree.client.domain.port.getClientDifference;

import dev.julioperez.littleTree.client.domain.model.ClientDifference;

import java.util.List;

public interface GetClientDifferenceOutputPort {
    List<ClientDifference> getClientDifference();
}
