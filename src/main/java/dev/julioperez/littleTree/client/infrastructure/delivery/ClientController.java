package dev.julioperez.littleTree.client.infrastructure.delivery;

import dev.julioperez.littleTree.client.domain.dto.CreateClientRequest;
import dev.julioperez.littleTree.client.domain.port.createClient.CreateClientInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/client")
@Slf4j
public class ClientController {

    private final CreateClientInputPort createClientInputPort;

    public ClientController(CreateClientInputPort createClientInputPort) {
        this.createClientInputPort = createClientInputPort;
    }

    @GetMapping
    public ResponseEntity<Boolean> createClient(@RequestBody CreateClientRequest createClientRequest) throws Exception{
        boolean response = createClientInputPort.createClient(createClientRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
