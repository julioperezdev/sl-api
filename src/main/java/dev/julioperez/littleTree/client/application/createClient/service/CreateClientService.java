package dev.julioperez.littleTree.client.application.createClient.service;

import dev.julioperez.littleTree.client.domain.model.Client;
import dev.julioperez.littleTree.client.domain.port.createClient.CreateClient;
import dev.julioperez.littleTree.client.domain.port.createClient.CreateClientOutputPort;

public class CreateClientService implements CreateClient {

    private final CreateClientOutputPort createClientOutputPort;

    public CreateClientService(CreateClientOutputPort createClientOutputPort) {
        this.createClientOutputPort = createClientOutputPort;
    }

    @Override
    public boolean createClient(Client newClient) throws Exception{
        Client newClientResponse = createClientOutputPort.createClient(newClient);
        return newClientResponse.equals(newClient);
    }
}
