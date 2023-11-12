package dev.julioperez.littleTree.client.client.application.getClients.adapter;

import dev.julioperez.littleTree.client.client.domain.model.Client;
import dev.julioperez.littleTree.client.client.domain.port.getClients.GetClientsOutputPort;
import dev.julioperez.littleTree.client.client.domain.port.mapper.ClientMapper;
import dev.julioperez.littleTree.client.client.infrastructure.repository.dao.ClientDao;
import dev.julioperez.littleTree.client.client.infrastructure.repository.entity.ClientEntity;

import java.util.Collections;
import java.util.List;

public class GetClientsAdapterRepository implements GetClientsOutputPort {

    private final ClientDao clientDao;
    private final ClientMapper clientMapper;

    public GetClientsAdapterRepository(ClientDao clientDao, ClientMapper clientMapper) {
        this.clientDao = clientDao;
        this.clientMapper = clientMapper;
    }
    @Override
    public List<Client> getClients(){
        List<ClientEntity> allEntityClients = clientDao.findAll();
        return allEntityClients.isEmpty()
                ? Collections.emptyList()
                : clientMapper.toClientsModel(allEntityClients);
    }

    @Override
    public List<Client> getClientsById(List<String> id) {
        List<ClientEntity> allById = clientDao.findAllById(id);
        return allById.isEmpty()
                ? Collections.emptyList()
                : clientMapper.toClientsModel(allById);
    }
}
