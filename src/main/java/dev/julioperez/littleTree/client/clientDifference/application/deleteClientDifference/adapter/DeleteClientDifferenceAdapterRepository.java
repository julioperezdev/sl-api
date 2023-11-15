package dev.julioperez.littleTree.client.clientDifference.application.deleteClientDifference.adapter;

import dev.julioperez.littleTree.client.clientDifference.domain.port.deleteClientDifference.DeleteClientDifferenceOutputPort;
import dev.julioperez.littleTree.client.clientDifference.infrastructure.repository.dao.ClientDifferenceDao;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DeleteClientDifferenceAdapterRepository implements DeleteClientDifferenceOutputPort {

    private final ClientDifferenceDao clientDifferenceDao;

    public DeleteClientDifferenceAdapterRepository(ClientDifferenceDao clientDifferenceDao) {
        this.clientDifferenceDao = clientDifferenceDao;
    }

    @Override
    public Boolean deleteClientDifferenceById(String id) {
        try{
            clientDifferenceDao.deleteById(id);
            return true;
        }catch (Exception exception){
            log.error("Error on deleteClientDifferenceById ", exception);
            return false;
        }
    }
}
