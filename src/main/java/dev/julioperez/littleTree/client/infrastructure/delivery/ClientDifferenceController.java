package dev.julioperez.littleTree.client.infrastructure.delivery;

import dev.julioperez.littleTree.client.domain.dto.CreateClientDifferenceRequest;
import dev.julioperez.littleTree.client.domain.dto.GetClientDifferenceResponse;
import dev.julioperez.littleTree.client.domain.dto.UpdateClientDifferenceRequest;
import dev.julioperez.littleTree.client.domain.model.ClientDifference;
import dev.julioperez.littleTree.client.domain.port.createClientDifference.CreateClientDifferenceInputPort;
import dev.julioperez.littleTree.client.domain.port.getClientDifference.GetClientDifferenceInputPort;
import dev.julioperez.littleTree.client.domain.port.updateClientDifference.UpdateClientDifferenceInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/client/difference")
@Slf4j
@CrossOrigin(origins = "*")
public class ClientDifferenceController {

    private final GetClientDifferenceInputPort getClientDifferenceInputPort;
    private final CreateClientDifferenceInputPort createClientDifferenceInputPort;
    private final UpdateClientDifferenceInputPort updateClientDifferenceInputPort;

    public ClientDifferenceController(GetClientDifferenceInputPort getClientDifferenceInputPort, CreateClientDifferenceInputPort createClientDifferenceInputPort, UpdateClientDifferenceInputPort updateClientDifferenceInputPort) {
        this.getClientDifferenceInputPort = getClientDifferenceInputPort;
        this.createClientDifferenceInputPort = createClientDifferenceInputPort;
        this.updateClientDifferenceInputPort = updateClientDifferenceInputPort;
    }

    @PostMapping("/get")
    public ResponseEntity<List<GetClientDifferenceResponse>> getAllClientDifferences() throws Exception {
        List<GetClientDifferenceResponse> clientDifferences = getClientDifferenceInputPort.getClientDifferenceDto();
        HttpStatus httpStatus = clientDifferences.isEmpty()
                ? HttpStatus.NO_CONTENT
                : HttpStatus.FOUND;
        return new ResponseEntity<>(clientDifferences, httpStatus);
    }

    @PutMapping("/get/{id}")
    public ResponseEntity<Optional<GetClientDifferenceResponse>> getClientDifferenceById(@PathVariable String id) throws Exception {
        Optional<GetClientDifferenceResponse> clientDifferences = getClientDifferenceInputPort.getClientDifferenceById(id);
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

    @PutMapping("/update")
    public ResponseEntity<ClientDifference> updateClientDifference(@RequestBody UpdateClientDifferenceRequest updateClientDifferenceRequest) throws Exception{
        ClientDifference clientDifferenceUpdated = updateClientDifferenceInputPort.updateClientDifference(updateClientDifferenceRequest);
        return new ResponseEntity<>(clientDifferenceUpdated, HttpStatus.OK);
    }

    @PutMapping("/get/by/client/id/{clientId}")
    public ResponseEntity<Boolean> hasClientDifferenceByClientId(@PathVariable String clientId){
        boolean hasClientDifferencesByClientId = getClientDifferenceInputPort.hasClientDifferenceByClientId(clientId);
        HttpStatus httpStatus = !hasClientDifferencesByClientId
                ? HttpStatus.NO_CONTENT
                : HttpStatus.FOUND;
        return new ResponseEntity<>(hasClientDifferencesByClientId, httpStatus);
    }
}
