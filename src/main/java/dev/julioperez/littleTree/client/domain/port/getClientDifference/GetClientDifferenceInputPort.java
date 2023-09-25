package dev.julioperez.littleTree.client.domain.port.getClientDifference;

import dev.julioperez.littleTree.client.domain.model.ClientDifference;

import java.util.List;
import java.util.Optional;

public interface GetClientDifferenceInputPort {
    List<ClientDifference> getClientDifference();
    Optional<ClientDifference> getOptionalClientDifferenceById(String id);
}
