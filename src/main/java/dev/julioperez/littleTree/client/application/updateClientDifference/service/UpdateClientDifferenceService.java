package dev.julioperez.littleTree.client.application.updateClientDifference.service;

import dev.julioperez.littleTree.client.domain.dto.UpdateClientDifferenceRequest;
import dev.julioperez.littleTree.client.domain.model.ClientDifference;
import dev.julioperez.littleTree.client.domain.port.getClientDifference.GetClientDifference;
import dev.julioperez.littleTree.client.domain.port.mapper.ClientDifferenceMapper;
import dev.julioperez.littleTree.client.domain.port.updateClientDifference.UpdateClientDifference;
import dev.julioperez.littleTree.client.domain.port.updateClientDifference.UpdateClientDifferenceOutputPort;

import java.util.Optional;

public class UpdateClientDifferenceService implements UpdateClientDifference {

    private final UpdateClientDifferenceOutputPort updateClientDifferenceOutputPort;
    private final GetClientDifference getClientDifference;
    private final ClientDifferenceMapper clientDifferenceMapper;

    public UpdateClientDifferenceService(UpdateClientDifferenceOutputPort updateClientDifferenceOutputPort, GetClientDifference getClientDifference, ClientDifferenceMapper clientDifferenceMapper) {
        this.updateClientDifferenceOutputPort = updateClientDifferenceOutputPort;
        this.getClientDifference = getClientDifference;
        this.clientDifferenceMapper = clientDifferenceMapper;
    }

    @Override
    public ClientDifference updateClientDifference(UpdateClientDifferenceRequest updateClientDifferenceRequest) {
        Optional<ClientDifference> optionalClientDifference = getClientDifference.getOptionalClientDifferenceById(updateClientDifferenceRequest.id());
        if(optionalClientDifference.isEmpty()) throw new IllegalArgumentException(String.format("%s id dont exist as ClientDifference", updateClientDifferenceRequest.id()));
        ClientDifference clientDifferenceToUpdate = clientDifferenceMapper.toClientDifferenceModel(optionalClientDifference.get(), updateClientDifferenceRequest);
        return updateClientDifferenceOutputPort.updateClientDifference(clientDifferenceToUpdate);
    }
}
