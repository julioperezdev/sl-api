package dev.julioperez.littleTree.client.application.updateClient.adapter;

import dev.julioperez.littleTree.client.domain.model.Client;
import dev.julioperez.littleTree.client.domain.port.mapper.ClientMapper;
import dev.julioperez.littleTree.client.domain.port.updateClient.UpdateClientOutputPort;
import dev.julioperez.littleTree.client.infrastructure.repository.dao.ClientDao;
import dev.julioperez.littleTree.client.infrastructure.repository.entity.ClientEntity;

public class UpdateClientAdapterRepository implements UpdateClientOutputPort {

    private final ClientDao clientDao;
    private final ClientMapper clientMapper;

    public UpdateClientAdapterRepository(ClientDao clientDao, ClientMapper clientMapper) {
        this.clientDao = clientDao;
        this.clientMapper = clientMapper;
    }

    @Override
    public Client updateClient(Client client){
        ClientEntity clientEntity = clientMapper.toClientEntity(client);
        clientDao.save(clientEntity);
        return clientMapper.toClientModel(clientEntity);
    }
}
