package dev.julioperez.littleTree.client.client.domain.port.updateClient;

import dev.julioperez.littleTree.client.client.domain.model.Client;

public interface UpdateClientOutputPort {
    Client updateClient(Client client) throws Exception;
}
