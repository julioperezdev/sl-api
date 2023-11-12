package dev.julioperez.littleTree.client.clientDifference.application.createClientDifference.service;

import dev.julioperez.littleTree.client.clientDifference.domain.dto.CreateClientDifferenceRequest;
import dev.julioperez.littleTree.client.clientDifference.domain.model.ClientDifference;
import dev.julioperez.littleTree.client.clientDifference.domain.port.createClientDifference.CreateClientDifference;
import dev.julioperez.littleTree.client.clientDifference.domain.port.createClientDifference.CreateClientDifferenceOutputPort;
import dev.julioperez.littleTree.client.clientDifference.domain.port.mapper.ClientDifferenceMapper;

public class CreateClientDifferenceService implements CreateClientDifference {

    private final CreateClientDifferenceOutputPort createClientDifferenceOutputPort;
    private final ClientDifferenceMapper clientDifferenceMapper;

    public CreateClientDifferenceService(CreateClientDifferenceOutputPort createClientDifferenceOutputPort, ClientDifferenceMapper clientDifferenceMapper) {
        this.createClientDifferenceOutputPort = createClientDifferenceOutputPort;
        this.clientDifferenceMapper = clientDifferenceMapper;
    }

    @Override
    public ClientDifference createClientDifference(CreateClientDifferenceRequest createClientDifferenceRequest) throws Exception{
        ClientDifference clientDifference = clientDifferenceMapper.toClientDifferenceModel(createClientDifferenceRequest);
        return createClientDifferenceOutputPort.createClientDifference(clientDifference);
    }
}
