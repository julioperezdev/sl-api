package dev.julioperez.littleTree.client.domain.port.getClients;

import dev.julioperez.littleTree.client.domain.model.Client;

import java.util.List;
import java.util.Optional;

public interface GetClients {

    List<Client> getClients();

    Optional<Client> getOptionalClientById(String id) throws Exception;

    Optional<Client> getOptionalClientByName(String name) throws Exception;
}
