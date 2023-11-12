package dev.julioperez.littleTree.client.client.application.updateClient.delivery;

import dev.julioperez.littleTree.client.client.domain.dto.UpdateClientRequest;
import dev.julioperez.littleTree.client.client.domain.model.Client;
import dev.julioperez.littleTree.client.client.domain.port.updateClient.UpdateClient;
import dev.julioperez.littleTree.client.client.domain.port.updateClient.UpdateClientInputPort;

public class UpdateClientDelivery implements UpdateClientInputPort {

    private final UpdateClient updateClient;

    public UpdateClientDelivery(UpdateClient updateClient) {
        this.updateClient = updateClient;
    }

    public Client updateClient(UpdateClientRequest updateClientRequest) throws Exception {
        return updateClient.updateClient(updateClientRequest);
    }
}
