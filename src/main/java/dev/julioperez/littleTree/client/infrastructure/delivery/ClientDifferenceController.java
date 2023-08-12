package dev.julioperez.littleTree.client.infrastructure.delivery;

import dev.julioperez.littleTree.client.domain.dto.CreateClientDifferenceRequest;
import dev.julioperez.littleTree.client.domain.model.ClientDifference;
import dev.julioperez.littleTree.client.domain.port.createClientDifference.CreateClientDifferenceInputPort;
import dev.julioperez.littleTree.client.domain.port.getClientDifference.GetClientDifferenceInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client/difference")
@Slf4j
public class ClientDifferenceController {

    private final GetClientDifferenceInputPort getClientDifferenceInputPort;
    private final CreateClientDifferenceInputPort createClientDifferenceInputPort;

    public ClientDifferenceController(GetClientDifferenceInputPort getClientDifferenceInputPort, CreateClientDifferenceInputPort createClientDifferenceInputPort) {
        this.getClientDifferenceInputPort = getClientDifferenceInputPort;

        this.createClientDifferenceInputPort = createClientDifferenceInputPort;
    }

    @PostMapping("/get")
    public ResponseEntity<List<ClientDifference>> getAllClientDifferences(){
        List<ClientDifference> clientDifferences = getClientDifferenceInputPort.getClientDifference();
        HttpStatus httpStatus = clientDifferences.isEmpty()
                ? HttpStatus.NO_CONTENT
                : HttpStatus.FOUND;
        return new ResponseEntity<>(clientDifferences, httpStatus);
    }

    @PostMapping("/create")
    public ResponseEntity<ClientDifference> createClientDifference(@RequestBody CreateClientDifferenceRequest createClientDifferenceRequest) throws Exception{
        ClientDifference newClientDifference = createClientDifferenceInputPort.createClientDifference(createClientDifferenceRequest);
        return new ResponseEntity<>(newClientDifference, HttpStatus.CREATED);
    }
}
