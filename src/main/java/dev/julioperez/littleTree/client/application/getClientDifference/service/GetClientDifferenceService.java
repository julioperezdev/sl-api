package dev.julioperez.littleTree.client.application.getClientDifference.service;

import dev.julioperez.littleTree.client.domain.model.ClientDifference;
import dev.julioperez.littleTree.client.domain.port.getClientDifference.GetClientDifference;
import dev.julioperez.littleTree.client.domain.port.getClientDifference.GetClientDifferenceOutputPort;

import java.util.List;
import java.util.Optional;

public class GetClientDifferenceService implements GetClientDifference {
    private final GetClientDifferenceOutputPort getClientDifferenceOutputPort;

    public GetClientDifferenceService(GetClientDifferenceOutputPort getClientDifferenceOutputPort) {
        this.getClientDifferenceOutputPort = getClientDifferenceOutputPort;
    }
    @Override
    public List<ClientDifference> getClientDifference() {
        return getClientDifferenceOutputPort.getClientDifference();
    }

    @Override
    public Optional<ClientDifference> getOptionalClientDifferenceById(String id){
        List<ClientDifference> allClientDifference = getClientDifference();
        return allClientDifference.stream()
                .filter(clientDifference -> clientDifference.getId().equals(id))
                .findFirst();
    }
}
