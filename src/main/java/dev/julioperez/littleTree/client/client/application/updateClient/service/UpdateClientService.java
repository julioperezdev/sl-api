package dev.julioperez.littleTree.client.client.application.updateClient.service;

import dev.julioperez.littleTree.client.client.domain.dto.UpdateClientRequest;
import dev.julioperez.littleTree.client.client.domain.model.Client;
import dev.julioperez.littleTree.client.client.domain.port.getClients.GetClients;
import dev.julioperez.littleTree.client.client.domain.port.mapper.ClientMapper;
import dev.julioperez.littleTree.client.client.domain.port.updateClient.UpdateClient;
import dev.julioperez.littleTree.client.client.domain.port.updateClient.UpdateClientOutputPort;

import java.util.Optional;

public class UpdateClientService implements UpdateClient {

    private final UpdateClientOutputPort updateClientOutputPort;
    private final GetClients getClients;
    private final ClientMapper clientMapper;

    public UpdateClientService(UpdateClientOutputPort updateClientOutputPort, GetClients getClients, ClientMapper clientMapper) {
        this.updateClientOutputPort = updateClientOutputPort;
        this.getClients = getClients;
        this.clientMapper = clientMapper;
    }

    @Override
    public Client updateClient(UpdateClientRequest updateClientRequest) throws Exception {
        Optional<Client> optionalClientById = getClients.getOptionalClientById(updateClientRequest.id());
        if(optionalClientById.isEmpty()) throw new IllegalArgumentException(String.format("%s value dont exist as Client", updateClientRequest.id()));
        Client clientToUpdate = clientMapper.toClientModel(optionalClientById.get(), updateClientRequest);
        return updateClientOutputPort.updateClient(clientToUpdate);
    }
}
