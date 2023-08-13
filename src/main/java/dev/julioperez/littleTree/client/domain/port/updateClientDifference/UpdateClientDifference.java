package dev.julioperez.littleTree.client.domain.port.updateClientDifference;

import dev.julioperez.littleTree.client.domain.dto.UpdateClientDifferenceRequest;
import dev.julioperez.littleTree.client.domain.model.ClientDifference;

public interface UpdateClientDifference {
    ClientDifference updateClientDifference(UpdateClientDifferenceRequest updateClientDifferenceRequest);
}
