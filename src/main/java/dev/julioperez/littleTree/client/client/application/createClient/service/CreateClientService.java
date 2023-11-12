package dev.julioperez.littleTree.client.client.application.createClient.service;

import dev.julioperez.littleTree.client.client.domain.dto.CreateClientRequest;
import dev.julioperez.littleTree.client.client.domain.model.Client;
import dev.julioperez.littleTree.client.client.domain.port.createClient.CreateClient;
import dev.julioperez.littleTree.client.client.domain.port.createClient.CreateClientOutputPort;
import dev.julioperez.littleTree.client.client.domain.port.getClients.GetClients;
import dev.julioperez.littleTree.client.client.domain.port.mapper.ClientMapper;

import java.util.Optional;

public class CreateClientService implements CreateClient {

    private final CreateClientOutputPort createClientOutputPort;
    private final ClientMapper clientMapper;
    private final GetClients getClients;

    public CreateClientService(CreateClientOutputPort createClientOutputPort, ClientMapper clientMapper,GetClients getClients) {
        this.createClientOutputPort = createClientOutputPort;
        this.clientMapper = clientMapper;
        this.getClients = getClients;
    }

    @Override
    public boolean createClient(CreateClientRequest createClientRequest) throws Exception{
        Optional<Client> optionalClientByName = getClients.getOptionalClientByName(createClientRequest.name().trim());
        if(optionalClientByName.isPresent()) throw new IllegalArgumentException(String.format("%s name exist with registered client",createClientRequest.name().trim()));
        Client newClient = clientMapper.toClientModel(createClientRequest);
        Client newClientResponse = createClientOutputPort.createClient(newClient);
        return newClientResponse.getId().equals(newClient.getId());
    }
}
