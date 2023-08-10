package dev.julioperez.littleTree.client.domain.port.createClient;

import dev.julioperez.littleTree.client.domain.model.Client;

public interface CreateClient {
    boolean createClient(Client newClient);
}
