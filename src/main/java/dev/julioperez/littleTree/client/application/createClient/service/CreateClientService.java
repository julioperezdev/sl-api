package dev.julioperez.littleTree.client.application.createClient.service;

import dev.julioperez.littleTree.client.domain.dto.CreateClientRequest;
import dev.julioperez.littleTree.client.domain.model.Client;
import dev.julioperez.littleTree.client.domain.port.createClient.CreateClient;
import dev.julioperez.littleTree.client.domain.port.createClient.CreateClientOutputPort;
import dev.julioperez.littleTree.client.domain.port.mapper.ClientMapper;

public class CreateClientService implements CreateClient {

    private final CreateClientOutputPort createClientOutputPort;
    private final ClientMapper clientMapper;

    public CreateClientService(CreateClientOutputPort createClientOutputPort, ClientMapper clientMapper) {
        this.createClientOutputPort = createClientOutputPort;
        this.clientMapper = clientMapper;
    }

    @Override
    public boolean createClient(CreateClientRequest createClientRequest) throws Exception{
        Client newClient = clientMapper.toClientModel(createClientRequest);
        Client newClientResponse = createClientOutputPort.createClient(newClient);
        return newClientResponse.getId().equals(newClient.getId());
    }
}
