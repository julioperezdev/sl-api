package dev.julioperez.littleTree.client.application.updateClient.delivery;

import dev.julioperez.littleTree.client.domain.dto.UpdateClientRequest;
import dev.julioperez.littleTree.client.domain.model.Client;
import dev.julioperez.littleTree.client.domain.port.updateClient.UpdateClient;
import dev.julioperez.littleTree.client.domain.port.updateClient.UpdateClientInputPort;

public class UpdateClientDelivery implements UpdateClientInputPort {

    private final UpdateClient updateClient;

    public UpdateClientDelivery(UpdateClient updateClient) {
        this.updateClient = updateClient;
    }

    public Client updateClient(UpdateClientRequest updateClientRequest) throws Exception {
        return updateClient.updateClient(updateClientRequest);
    }
}
