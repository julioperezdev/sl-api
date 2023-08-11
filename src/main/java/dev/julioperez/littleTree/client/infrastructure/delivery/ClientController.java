package dev.julioperez.littleTree.client.infrastructure.delivery;

import dev.julioperez.littleTree.client.domain.dto.CreateClientRequest;
import dev.julioperez.littleTree.client.domain.dto.UpdateClientRequest;
import dev.julioperez.littleTree.client.domain.model.Client;
import dev.julioperez.littleTree.client.domain.port.createClient.CreateClientInputPort;
import dev.julioperez.littleTree.client.domain.port.getClients.GetClientsInputPort;
import dev.julioperez.littleTree.client.domain.port.updateClient.UpdateClientInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
@Slf4j
public class ClientController {

    private final CreateClientInputPort createClientInputPort;
    private final GetClientsInputPort getClientsInputPort;
    private final UpdateClientInputPort updateClientInputPort;

    public ClientController(CreateClientInputPort createClientInputPort, GetClientsInputPort getClientsInputPort, UpdateClientInputPort updateClientInputPort) {
        this.createClientInputPort = createClientInputPort;
        this.getClientsInputPort = getClientsInputPort;
        this.updateClientInputPort = updateClientInputPort;
    }

    @PostMapping("/create")
    public ResponseEntity<Boolean> createClient(@RequestBody CreateClientRequest createClientRequest) throws Exception{
        boolean response = createClientInputPort.createClient(createClientRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/get")
    public ResponseEntity<List<Client>> getAllClients() throws Exception {
        List<Client> allClients = getClientsInputPort.getClients();
        HttpStatus httpStatus = allClients.isEmpty()
                ? HttpStatus.NO_CONTENT
                : HttpStatus.FOUND;
        return new ResponseEntity<>(allClients, httpStatus);
    }

    @PutMapping("/update")
    public ResponseEntity<Client> updateClients(@RequestBody UpdateClientRequest updateClientRequest) throws Exception {
        Client updatedClient = updateClientInputPort.updateClient(updateClientRequest);
        return new ResponseEntity<>(updatedClient, HttpStatus.OK);
    }

}
