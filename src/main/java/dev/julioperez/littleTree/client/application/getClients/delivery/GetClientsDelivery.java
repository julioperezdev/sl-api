package dev.julioperez.littleTree.client.application.getClients.delivery;

import dev.julioperez.littleTree.client.domain.model.Client;
import dev.julioperez.littleTree.client.domain.port.getClients.GetClients;
import dev.julioperez.littleTree.client.domain.port.getClients.GetClientsInputPort;

import java.util.List;
import java.util.Optional;

public class GetClientsDelivery implements GetClientsInputPort {

    private final GetClients getClients;

    public GetClientsDelivery(GetClients getClients) {
        this.getClients = getClients;
    }

    @Override
    public List<Client> getClients() throws Exception {
        return getClients.getClients();
    }

    @Override
    public List<String> getClientsNames() {
        return getClients.getClientsNames();
    }

    @Override
    public Optional<Client> getOptionalClientById(String id) throws Exception {
        return getClients.getOptionalClientById(id);
    }

    @Override
    public Optional<Client> getOptionalClientByName(String name) throws Exception {
        return getClients.getOptionalClientByName(name);
    }
}
