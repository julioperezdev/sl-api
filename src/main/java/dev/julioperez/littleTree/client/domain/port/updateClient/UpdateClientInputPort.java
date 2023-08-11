package dev.julioperez.littleTree.client.domain.port.updateClient;

import dev.julioperez.littleTree.client.domain.dto.UpdateClientRequest;
import dev.julioperez.littleTree.client.domain.model.Client;

public interface UpdateClientInputPort {
    Client updateClient(UpdateClientRequest updateClientRequest) throws Exception;
}
