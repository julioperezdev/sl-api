package dev.julioperez.littleTree.client.clientDifference.domain.port.updateClientDifference;

import dev.julioperez.littleTree.client.clientDifference.domain.dto.UpdateClientDifferenceRequest;
import dev.julioperez.littleTree.client.clientDifference.domain.model.ClientDifference;

public interface UpdateClientDifference {
    ClientDifference updateClientDifference(UpdateClientDifferenceRequest updateClientDifferenceRequest);
}
