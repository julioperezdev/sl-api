package dev.julioperez.littleTree.service;

import dev.julioperez.littleTree.model.Client;

public interface ClientService {
    Client createClient(Client client) throws Exception;
    Client getClientByPhone(String phone) throws Exception;
    Client updateClientById(Client client) throws Exception;

}
