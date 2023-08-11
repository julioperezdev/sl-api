package dev.julioperez.littleTree.client.domain.port.getClients;

import dev.julioperez.littleTree.client.domain.model.Client;

import java.util.List;

public interface GetClientsInputPort {
    List<Client> getClients() throws Exception;
}
