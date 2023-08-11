package dev.julioperez.littleTree.client.domain.port.updateClient;

import dev.julioperez.littleTree.client.domain.dto.UpdateClientRequest;
import dev.julioperez.littleTree.client.domain.model.Client;

public interface UpdateClient {
    Client updateClient(UpdateClientRequest updateClientRequest) throws Exception;
}
