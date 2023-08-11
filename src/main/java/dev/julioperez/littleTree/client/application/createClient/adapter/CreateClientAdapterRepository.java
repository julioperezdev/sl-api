package dev.julioperez.littleTree.client.application.createClient.adapter;

import dev.julioperez.littleTree.client.domain.model.Client;
import dev.julioperez.littleTree.client.domain.port.createClient.CreateClientOutputPort;
import dev.julioperez.littleTree.client.domain.port.mapper.ClientMapper;
import dev.julioperez.littleTree.client.infrastructure.repository.dao.ClientDao;
import dev.julioperez.littleTree.client.infrastructure.repository.entity.ClientEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class CreateClientAdapterRepository implements CreateClientOutputPort {

    private final ClientDao clientDao;
    private final ClientMapper clientMapper;

    @Override
    public Client createClient(Client newClient) throws Exception{
        ClientEntity clientPreSaving = clientMapper.toClientEntity(newClient);
        ClientEntity clientSaved = clientDao.save(clientPreSaving);
        return clientMapper.toClientModel(clientSaved);
    }
}
