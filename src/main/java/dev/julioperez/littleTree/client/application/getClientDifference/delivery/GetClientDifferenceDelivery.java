package dev.julioperez.littleTree.client.application.getClientDifference.delivery;

import dev.julioperez.littleTree.client.domain.model.ClientDifference;
import dev.julioperez.littleTree.client.domain.port.getClientDifference.GetClientDifference;
import dev.julioperez.littleTree.client.domain.port.getClientDifference.GetClientDifferenceInputPort;

import java.util.List;
import java.util.Optional;

public class GetClientDifferenceDelivery implements GetClientDifferenceInputPort {
    private final GetClientDifference getClientDifference;

    public GetClientDifferenceDelivery(GetClientDifference getClientDifference) {
        this.getClientDifference = getClientDifference;
    }

    @Override
    public List<ClientDifference> getClientDifference() {
        return getClientDifference.getClientDifference();
    }


    @Override
    public Optional<ClientDifference> getOptionalClientDifferenceById(String id) {
        return getClientDifference.getOptionalClientDifferenceById(id);
    }
}
