package dev.julioperez.littleTree.client.client.domain.port.updateClient;

import dev.julioperez.littleTree.client.client.domain.dto.UpdateClientRequest;
import dev.julioperez.littleTree.client.client.domain.model.Client;

public interface UpdateClient {
    Client updateClient(UpdateClientRequest updateClientRequest) throws Exception;
}
