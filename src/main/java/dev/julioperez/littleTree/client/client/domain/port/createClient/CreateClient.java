package dev.julioperez.littleTree.client.client.domain.port.createClient;

import dev.julioperez.littleTree.client.client.domain.dto.CreateClientRequest;

public interface CreateClient {
    boolean createClient(CreateClientRequest createClientRequest) throws Exception;
}
