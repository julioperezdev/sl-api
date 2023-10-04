package dev.julioperez.littleTree.client.application.getClients.service;

import dev.julioperez.littleTree.client.domain.model.Client;
import dev.julioperez.littleTree.client.domain.model.ClientId;
import dev.julioperez.littleTree.client.domain.port.getClients.GetClients;
import dev.julioperez.littleTree.client.domain.port.getClients.GetClientsOutputPort;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
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
    public Map<String, String> getClientsNameById(List<String> idList) {
        List<Client> clientsById = getClientsOutputPort.getClientsById(idList);
        return clientsById.stream().collect(Collectors.toMap(Client::getId, Client::getName));
    }

    @Override
    public Optional<Client> getOptionalClientById(String id){
        List<Client> allClients = getClients();
        return allClients.stream()
                .filter(client -> client.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<String> getOptionalClientNameById(String id){
        Client client = getOptionalClientById(id).orElse(null);
        if(client == null){
            log.error("error to get Client with Id {}", id);
            return Optional.empty();
        }
        return Optional.of(client.getName());
    }

    @Override
    public Optional<Client> getOptionalClientByName(String name) throws Exception {
        List<Client> allClients = getClients();
        return allClients.stream()
                .filter(client -> client.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
