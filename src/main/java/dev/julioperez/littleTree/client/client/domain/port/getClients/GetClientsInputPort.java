package dev.julioperez.littleTree.client.client.domain.port.getClients;

import dev.julioperez.littleTree.client.client.domain.model.Client;

import java.util.List;
import java.util.Optional;

public interface GetClientsInputPort {
    List<Client> getClients() throws Exception;
    List<String> getClientsNames();

    Optional<Client> getOptionalClientById(String id) throws Exception;
    Optional<Client> getOptionalClientByName(String name) throws Exception;
}
