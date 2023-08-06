package dev.julioperez.littleTree.service.implementation;

import dev.julioperez.littleTree.model.Client;
import dev.julioperez.littleTree.repository.ClientRepository;
import dev.julioperez.littleTree.service.ClientService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Service
public class ClientServiceImplementation implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImplementation(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client createClient(Client client) throws Exception {
        try{
            client.setUuid(UUID.randomUUID().toString());
            client.setCreatedAt(Date.from(Instant.now()));
            return clientRepository.save(client);
        }catch (Exception exception){
            throw new Exception("Error in createClient method ", exception);
        }
    }

    @Override
    public Client getClientByPhone(String phone) throws Exception {
        try{
            return clientRepository.getClientByPhone(phone).orElseThrow();
        }catch (Exception exception){
            throw new Exception("Error in getClientByClient method ", exception);
        }
    }

    @Override
    public Client updateClientById(Client client) throws Exception {
        try{
            return clientRepository.save(client);
        }catch (Exception exception){
            throw new Exception("Error in createClient method ", exception);
        }
    }
}
