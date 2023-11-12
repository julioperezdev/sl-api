package dev.julioperez.littleTree.client.client.domain.port.createClient;

import dev.julioperez.littleTree.client.client.domain.model.Client;

public interface CreateClientOutputPort {
    Client createClient(Client newClient) throws Exception;
}
