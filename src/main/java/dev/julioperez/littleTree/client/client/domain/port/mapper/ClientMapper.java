package dev.julioperez.littleTree.client.client.domain.port.mapper;

import dev.julioperez.littleTree.client.client.domain.dto.CreateClientRequest;
import dev.julioperez.littleTree.client.client.domain.dto.UpdateClientRequest;
import dev.julioperez.littleTree.client.client.domain.model.Client;
import dev.julioperez.littleTree.client.client.infrastructure.repository.entity.ClientEntity;

import java.util.List;

public interface ClientMapper {
    Client toClientModel(CreateClientRequest createClientRequest);
    Client toClientModel(Client client, UpdateClientRequest updateClientRequest);
    List<Client> toClientsModel(List<ClientEntity> clientsEntity);
    Client toClientModel(ClientEntity clientEntity);
    ClientEntity toClientEntity(Client client);
}
