package dev.julioperez.littleTree.client.domain.port.getClients;

import dev.julioperez.littleTree.client.domain.model.Client;

import java.util.List;
import java.util.Optional;

public interface GetClientsOutputPort {
    List<Client> getClients();
}
