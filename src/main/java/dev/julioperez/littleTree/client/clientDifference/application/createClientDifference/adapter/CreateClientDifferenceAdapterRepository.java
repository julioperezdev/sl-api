package dev.julioperez.littleTree.client.clientDifference.application.createClientDifference.adapter;

import dev.julioperez.littleTree.client.clientDifference.domain.model.ClientDifference;
import dev.julioperez.littleTree.client.clientDifference.domain.port.createClientDifference.CreateClientDifferenceOutputPort;
import dev.julioperez.littleTree.client.clientDifference.domain.port.mapper.ClientDifferenceMapper;
import dev.julioperez.littleTree.client.clientDifference.infrastructure.repository.dao.ClientDifferenceDao;
import dev.julioperez.littleTree.client.clientDifference.infrastructure.repository.entity.ClientDifferenceEntity;

public class CreateClientDifferenceAdapterRepository implements CreateClientDifferenceOutputPort {

    private final ClientDifferenceDao clientDifferenceDao;
    private final ClientDifferenceMapper clientDifferenceMapper;

    public CreateClientDifferenceAdapterRepository(ClientDifferenceDao clientDifferenceDao, ClientDifferenceMapper clientDifferenceMapper) {
        this.clientDifferenceDao = clientDifferenceDao;
        this.clientDifferenceMapper = clientDifferenceMapper;
    }

    @Override
    public ClientDifference createClientDifference(ClientDifference clientDifference){
        ClientDifferenceEntity clientDifferenceEntity = clientDifferenceMapper.toClientDifferenceEntity(clientDifference);
        clientDifferenceDao.save(clientDifferenceEntity);
        return clientDifferenceMapper.toClientDifferenceModel(clientDifferenceEntity);
    }
}
