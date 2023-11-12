package dev.julioperez.littleTree.client.clientDifference.application.modelMapper;

import dev.julioperez.littleTree.client.clientDifference.domain.dto.CreateClientDifferenceRequest;
import dev.julioperez.littleTree.client.clientDifference.domain.dto.UpdateClientDifferenceRequest;
import dev.julioperez.littleTree.client.clientDifference.domain.model.ClientDifference;
import dev.julioperez.littleTree.client.clientDifference.domain.port.mapper.ClientDifferenceMapper;
import dev.julioperez.littleTree.client.clientDifference.infrastructure.repository.entity.ClientDifferenceEntity;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class ClientDifferenceModelMapper implements ClientDifferenceMapper {

    @Override
    public ClientDifference toClientDifferenceModel(CreateClientDifferenceRequest createClientDifferenceRequest) {
        return new ClientDifference(
                createClientDifferenceRequest.id(),
                Date.from(Instant.now()),
                Date.from(Instant.now()),
                createClientDifferenceRequest.clientId(),
                createClientDifferenceRequest.amount(),
                createClientDifferenceRequest.description(),
                createClientDifferenceRequest.differenceType(),
                "pendiente");
    }

    @Override
    public ClientDifference toClientDifferenceModel(ClientDifference clientDifference, UpdateClientDifferenceRequest updateClientDifferenceRequest) {
        return new ClientDifference(clientDifference.getId(),
                clientDifference.getCreatedAt(),
                Date.from(Instant.now()),
                clientDifference.getClientId(),
                updateClientDifferenceRequest.amount(),
                updateClientDifferenceRequest.description(),
                updateClientDifferenceRequest.differenceType(),
                updateClientDifferenceRequest.differenceStatus());
    }

    @Override
    public ClientDifference toClientDifferenceModel(ClientDifferenceEntity clientDifferenceEntity) {
        return new ClientDifference(
                clientDifferenceEntity.getId(),
                clientDifferenceEntity.getCreatedAt(),
                clientDifferenceEntity.getUpdatedAt(),
                clientDifferenceEntity.getClientId(),
                clientDifferenceEntity.getAmount(),
                clientDifferenceEntity.getDescription(),
                clientDifferenceEntity.getDifferenceType(),
                clientDifferenceEntity.getDifferenceStatus());
    }

    @Override
    public List<ClientDifference> toClientDifferencesModel(List<ClientDifferenceEntity> clientDifferenceEntities) {
        return clientDifferenceEntities
                .stream()
                .map(this::toClientDifferenceModel)
                .toList();
    }

    @Override
    public ClientDifferenceEntity toClientDifferenceEntity(ClientDifference clientDifference) {
        return new ClientDifferenceEntity(
           clientDifference.getId(),
           clientDifference.getClientId(),
           clientDifference.getAmount(),
           clientDifference.getDescription(),
           clientDifference.getDifferenceType(),
           clientDifference.getDifferenceStatus(),
           clientDifference.getCreatedAt(),
           clientDifference.getUpdatedAt());
    }
}
