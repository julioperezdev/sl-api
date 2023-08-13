package dev.julioperez.littleTree.client.domain.port.createClient;

import dev.julioperez.littleTree.client.domain.dto.CreateClientRequest;
import dev.julioperez.littleTree.client.domain.model.Client;

public interface CreateClient {
    boolean createClient(CreateClientRequest createClientRequest) throws Exception;
}
