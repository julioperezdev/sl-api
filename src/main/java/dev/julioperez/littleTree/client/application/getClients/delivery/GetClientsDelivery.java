package dev.julioperez.littleTree.client.application.getClients.delivery;

import dev.julioperez.littleTree.client.domain.model.Client;
import dev.julioperez.littleTree.client.domain.port.getClients.GetClients;
import dev.julioperez.littleTree.client.domain.port.getClients.GetClientsInputPort;

import java.util.List;

public class GetClientsDelivery implements GetClientsInputPort {

    private final GetClients getClients;

    public GetClientsDelivery(GetClients getClients) {
        this.getClients = getClients;
    }

    @Override
    public List<Client> getClients() throws Exception {
        return getClients.getClients();
    }
}
