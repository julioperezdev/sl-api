package dev.julioperez.littleTree.client.domain.port.mapper;

import dev.julioperez.littleTree.client.domain.dto.CreateClientDifferenceRequest;
import dev.julioperez.littleTree.client.domain.dto.UpdateClientDifferenceRequest;
import dev.julioperez.littleTree.client.domain.model.ClientDifference;
import dev.julioperez.littleTree.client.infrastructure.repository.entity.ClientDifferenceEntity;

import java.util.List;

public interface ClientDifferenceMapper {

    ClientDifference toClientDifferenceModel(CreateClientDifferenceRequest createClientDifferenceRequest);
    ClientDifference toClientDifferenceModel(ClientDifference clientDifference, UpdateClientDifferenceRequest updateClientDifferenceRequest);
    ClientDifference toClientDifferenceModel(ClientDifferenceEntity clientDifferenceEntity);
    List<ClientDifference> toClientDifferencesModel(List<ClientDifferenceEntity> clientDifferenceEntities);
    ClientDifferenceEntity toClientDifferenceEntity(ClientDifference clientDifference);
}
