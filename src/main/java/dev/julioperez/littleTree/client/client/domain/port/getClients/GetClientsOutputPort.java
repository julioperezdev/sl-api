package dev.julioperez.littleTree.client.client.domain.port.getClients;

import dev.julioperez.littleTree.client.client.domain.model.Client;

import java.util.List;

public interface GetClientsOutputPort {
    List<Client> getClients();
    List<Client> getClientsById(List<String> id);
}
