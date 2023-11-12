package dev.julioperez.littleTree.client.clientDifference.domain.port.mapper;

import dev.julioperez.littleTree.client.clientDifference.domain.dto.CreateClientDifferenceRequest;
import dev.julioperez.littleTree.client.clientDifference.domain.dto.UpdateClientDifferenceRequest;
import dev.julioperez.littleTree.client.clientDifference.domain.model.ClientDifference;
import dev.julioperez.littleTree.client.clientDifference.infrastructure.repository.entity.ClientDifferenceEntity;

import java.util.List;

public interface ClientDifferenceMapper {

    ClientDifference toClientDifferenceModel(CreateClientDifferenceRequest createClientDifferenceRequest);
    ClientDifference toClientDifferenceModel(ClientDifference clientDifference, UpdateClientDifferenceRequest updateClientDifferenceRequest);
    ClientDifference toClientDifferenceModel(ClientDifferenceEntity clientDifferenceEntity);
    List<ClientDifference> toClientDifferencesModel(List<ClientDifferenceEntity> clientDifferenceEntities);
    ClientDifferenceEntity toClientDifferenceEntity(ClientDifference clientDifference);
}
