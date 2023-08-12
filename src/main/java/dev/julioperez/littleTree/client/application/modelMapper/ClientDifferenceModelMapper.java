package dev.julioperez.littleTree.client.application.modelMapper;

import dev.julioperez.littleTree.client.domain.dto.CreateClientDifferenceRequest;
import dev.julioperez.littleTree.client.domain.model.ClientDifference;
import dev.julioperez.littleTree.client.domain.port.mapper.ClientDifferenceMapper;
import dev.julioperez.littleTree.client.infrastructure.repository.entity.ClientDifferenceEntity;

import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class ClientDifferenceModelMapper implements ClientDifferenceMapper {

    @Override
    public ClientDifference toClientDifferenceModel(CreateClientDifferenceRequest createClientDifferenceRequest) {
        return new ClientDifference(UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                createClientDifferenceRequest.clientId(),
                createClientDifferenceRequest.amount(),
                createClientDifferenceRequest.description(),
                createClientDifferenceRequest.differenceType(),
                createClientDifferenceRequest.differenceStatus());
    }

    @Override
    public ClientDifference toClientDifferenceModel(ClientDifferenceEntity clientDifferenceEntity) {
        return new ClientDifference(
                clientDifferenceEntity.getId(),
                clientDifferenceEntity.getCreatedAt(),
                clientDifferenceEntity.getClientId(),
                clientDifferenceEntity.getAmount(),
                clientDifferenceEntity.getDescription(),
                clientDifferenceEntity.getDifferenceType(),
                clientDifferenceEntity.getDifferenceStatus());
    }

    @Override
    public List<ClientDifference> toClientDifferencesModel(List<ClientDifferenceEntity> clientDifferenceEntities) {
        return null;
    }

    @Override
    public ClientDifferenceEntity toClientDifferenceEntity(ClientDifference clientDifference) {
        return new ClientDifferenceEntity(
           clientDifference.getId(),
           clientDifference.getCreatedAt(),
           clientDifference.getClientId(),
           clientDifference.getAmount(),
           clientDifference.getDescription(),
           clientDifference.getDifferenceType(),
           clientDifference.getDifferenceStatus());
    }
}
