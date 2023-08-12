package dev.julioperez.littleTree.client.application.getClientDifference.adapter;

import dev.julioperez.littleTree.client.domain.model.ClientDifference;
import dev.julioperez.littleTree.client.domain.port.getClientDifference.GetClientDifferenceOutputPort;
import dev.julioperez.littleTree.client.domain.port.mapper.ClientDifferenceMapper;
import dev.julioperez.littleTree.client.infrastructure.repository.dao.ClientDifferenceDao;
import dev.julioperez.littleTree.client.infrastructure.repository.entity.ClientDifferenceEntity;

import java.util.Collections;
import java.util.List;

public class GetClientDifferenceAdapterRepository implements GetClientDifferenceOutputPort {
    private final ClientDifferenceDao clientDifferenceDao;
    private final ClientDifferenceMapper clientDifferenceMapper;

    public GetClientDifferenceAdapterRepository(ClientDifferenceDao clientDifferenceDao, ClientDifferenceMapper clientDifferenceMapper) {
        this.clientDifferenceDao = clientDifferenceDao;
        this.clientDifferenceMapper = clientDifferenceMapper;
    }

    @Override
    public List<ClientDifference> getClientDifference() {
        List<ClientDifferenceEntity> allClientDifferenceEntity = clientDifferenceDao.findAll();
        return allClientDifferenceEntity.isEmpty()
                ? Collections.emptyList()
                : clientDifferenceMapper.toClientDifferencesModel(allClientDifferenceEntity);
    }
}
