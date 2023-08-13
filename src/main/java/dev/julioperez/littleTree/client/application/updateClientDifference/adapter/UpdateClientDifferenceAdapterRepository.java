package dev.julioperez.littleTree.client.application.updateClientDifference.adapter;

import dev.julioperez.littleTree.client.domain.model.ClientDifference;
import dev.julioperez.littleTree.client.domain.port.mapper.ClientDifferenceMapper;
import dev.julioperez.littleTree.client.domain.port.updateClientDifference.UpdateClientDifferenceOutputPort;
import dev.julioperez.littleTree.client.infrastructure.repository.dao.ClientDifferenceDao;
import dev.julioperez.littleTree.client.infrastructure.repository.entity.ClientDifferenceEntity;

public class UpdateClientDifferenceAdapterRepository implements UpdateClientDifferenceOutputPort {
    private final ClientDifferenceDao clientDifferenceDao;
    private final ClientDifferenceMapper clientDifferenceMapper;

    public UpdateClientDifferenceAdapterRepository(ClientDifferenceDao clientDifferenceDao, ClientDifferenceMapper clientDifferenceMapper) {
        this.clientDifferenceDao = clientDifferenceDao;
        this.clientDifferenceMapper = clientDifferenceMapper;
    }

    @Override
    public ClientDifference updateClientDifference(ClientDifference clientDifference) {
        ClientDifferenceEntity clientDifferenceEntity = clientDifferenceMapper.toClientDifferenceEntity(clientDifference);
        clientDifferenceDao.save(clientDifferenceEntity);
        return clientDifferenceMapper.toClientDifferenceModel(clientDifferenceEntity);
    }
}
