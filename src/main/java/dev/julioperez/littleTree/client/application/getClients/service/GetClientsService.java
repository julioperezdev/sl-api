package dev.julioperez.littleTree.client.application.getClients.service;

import dev.julioperez.littleTree.client.domain.model.Client;
import dev.julioperez.littleTree.client.domain.model.ClientId;
import dev.julioperez.littleTree.client.domain.port.getClients.GetClients;
import dev.julioperez.littleTree.client.domain.port.getClients.GetClientsOutputPort;

import java.util.List;
import java.util.Optional;

public class GetClientsService implements GetClients {

    private final GetClientsOutputPort getClientsOutputPort;

    public GetClientsService(GetClientsOutputPort getClientsOutputPort) {
        this.getClientsOutputPort = getClientsOutputPort;
    }

    @Override
    public List<Client> getClients(){
        return getClientsOutputPort.getClients();
    }

    @Override
    public Optional<Client> getOptionalClientById(String id){
        List<Client> allClients = getClients();
        return allClients.stream()
                .filter(client -> client.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Client> getOptionalClientByName(String name) throws Exception {
        List<Client> allClients = getClients();
        return allClients.stream()
                .filter(client -> client.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
