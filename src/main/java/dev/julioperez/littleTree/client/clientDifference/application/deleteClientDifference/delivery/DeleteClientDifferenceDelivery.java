package dev.julioperez.littleTree.client.clientDifference.application.deleteClientDifference.delivery;

import dev.julioperez.littleTree.client.clientDifference.domain.port.deleteClientDifference.DeleteClientDifference;
import dev.julioperez.littleTree.client.clientDifference.domain.port.deleteClientDifference.DeleteClientDifferenceInputPort;

public class DeleteClientDifferenceDelivery implements DeleteClientDifferenceInputPort {
    private final DeleteClientDifference deleteClientDifference;

    public DeleteClientDifferenceDelivery(DeleteClientDifference deleteClientDifference) {
        this.deleteClientDifference = deleteClientDifference;
    }

    public Boolean deleteClientDifferenceById(String id){
        return deleteClientDifference.deleteClientDifferenceById(id);
    }
}
