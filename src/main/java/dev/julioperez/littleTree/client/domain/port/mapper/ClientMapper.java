package dev.julioperez.littleTree.client.domain.port.mapper;

import dev.julioperez.littleTree.client.domain.dto.CreateClientRequest;
import dev.julioperez.littleTree.client.domain.model.Client;
import dev.julioperez.littleTree.client.infrastructure.repository.entity.ClientEntity;

public interface ClientMapper {
    Client toClientModel(CreateClientRequest createClientRequest);
    Client toClientModel(ClientEntity clientEntity);
    ClientEntity toClientEntity(Client client);
}
