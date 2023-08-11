package dev.julioperez.littleTree.client.domain.port.mapper;

import dev.julioperez.littleTree.client.domain.dto.CreateClientRequest;
import dev.julioperez.littleTree.client.domain.model.Client;
import dev.julioperez.littleTree.client.infrastructure.repository.entity.ClientEntity;

import java.util.List;

public interface ClientMapper {
    Client toClientModel(CreateClientRequest createClientRequest);
    List<Client> toClientsModel(List<ClientEntity> clientsEntity);
    Client toClientModel(ClientEntity clientEntity);
    ClientEntity toClientEntity(Client client);
}
