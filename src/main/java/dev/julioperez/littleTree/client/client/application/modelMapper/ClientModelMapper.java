package dev.julioperez.littleTree.client.client.application.modelMapper;

import dev.julioperez.littleTree.client.client.domain.dto.CreateClientRequest;
import dev.julioperez.littleTree.client.client.domain.dto.UpdateClientRequest;
import dev.julioperez.littleTree.client.client.domain.model.Client;
import dev.julioperez.littleTree.client.client.domain.port.mapper.ClientMapper;
import dev.julioperez.littleTree.client.client.infrastructure.repository.entity.ClientEntity;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class ClientModelMapper implements ClientMapper {

    @Override
    public Client toClientModel(CreateClientRequest createClientRequest) {
        return new Client(
                createClientRequest.id(),
                createClientRequest.name().trim(),
                createClientRequest.phone().trim(),
                createClientRequest.address(),
                createClientRequest.description(),
                Date.from(Instant.now()),
                Date.from(Instant.now()));
    }

    @Override
    public Client toClientModel(Client client, UpdateClientRequest updateClientRequest) {
        return new Client(
                updateClientRequest.id(),
                client.getName(),
                updateClientRequest.phone(),
                updateClientRequest.address(),
                updateClientRequest.description(),
                client.getCreatedAt(),
                Date.from(Instant.now()));
    }

    @Override
    public List<Client> toClientsModel(List<ClientEntity> clientsEntity) {
        return clientsEntity.stream().map(this::toClientModel).toList();
    }

    @Override
    public Client toClientModel(ClientEntity clientEntity) {
        return new Client(
                clientEntity.getId(),
                clientEntity.getName(),
                clientEntity.getPhone(),
                clientEntity.getAddress(),
                clientEntity.getDescription(),
                clientEntity.getCreatedAt(),
                clientEntity.getUpdatedAt());
    }

    @Override
    public ClientEntity toClientEntity(Client client) {
        return new ClientEntity(
                client.getId(),
                client.getName(),
                client.getPhone(),
                client.getAddress(),
                client.getDescription(),
                client.getCreatedAt(),
                client.getUpdatedAt());
    }
}
