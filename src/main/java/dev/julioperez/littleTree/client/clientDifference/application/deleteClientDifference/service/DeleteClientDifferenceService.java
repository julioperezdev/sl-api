package dev.julioperez.littleTree.client.clientDifference.application.deleteClientDifference.service;

import dev.julioperez.littleTree.client.clientDifference.domain.port.deleteClientDifference.DeleteClientDifference;
import dev.julioperez.littleTree.client.clientDifference.domain.port.deleteClientDifference.DeleteClientDifferenceOutputPort;

public class DeleteClientDifferenceService implements DeleteClientDifference {

    private final DeleteClientDifferenceOutputPort deleteClientDifferenceOutputPort;

    public DeleteClientDifferenceService(DeleteClientDifferenceOutputPort deleteClientDifferenceOutputPort) {
        this.deleteClientDifferenceOutputPort = deleteClientDifferenceOutputPort;
    }

    @Override
    public Boolean deleteClientDifferenceById(String id) {
        return deleteClientDifferenceOutputPort.deleteClientDifferenceById(id);
    }
}
