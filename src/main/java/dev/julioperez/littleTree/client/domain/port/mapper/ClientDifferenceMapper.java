package dev.julioperez.littleTree.client.domain.port.mapper;

import dev.julioperez.littleTree.client.domain.dto.CreateClientDifferenceRequest;
import dev.julioperez.littleTree.client.domain.model.ClientDifference;
import dev.julioperez.littleTree.client.infrastructure.repository.entity.ClientDifferenceEntity;

import java.util.List;

public interface ClientDifferenceMapper {

    ClientDifference toClientDifferenceModel(CreateClientDifferenceRequest createClientDifferenceRequest);
    ClientDifference toClientDifferenceModel(ClientDifferenceEntity clientDifferenceEntity);
    List<ClientDifference> toClientDifferencesModel(List<ClientDifferenceEntity> clientDifferenceEntities);
    ClientDifferenceEntity toClientDifferenceEntity(ClientDifference clientDifference);
}
