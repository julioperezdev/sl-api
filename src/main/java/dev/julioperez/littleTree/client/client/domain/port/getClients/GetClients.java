package dev.julioperez.littleTree.client.client.domain.port.getClients;

import dev.julioperez.littleTree.client.client.domain.model.Client;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface GetClients {

    List<Client> getClients();

    List<String> getClientsNames();
    Map<String, String> getClientsNameById(List<String> idList);

    Optional<Client> getOptionalClientById(String id) throws Exception;
    Optional<String> getOptionalClientNameById(String id) throws Exception;

    Optional<Client> getOptionalClientByName(String name) throws Exception;
}
