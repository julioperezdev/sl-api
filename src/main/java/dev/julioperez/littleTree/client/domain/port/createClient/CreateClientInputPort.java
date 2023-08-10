package dev.julioperez.littleTree.client.domain.port.createClient;

import dev.julioperez.littleTree.client.domain.dto.CreateClientRequest;

public interface CreateClientInputPort {
    boolean createClient(CreateClientRequest createClientRequest);
}
