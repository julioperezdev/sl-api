package dev.julioperez.littleTree.provider.infrastructure.delivery;

import dev.julioperez.littleTree.client.domain.model.Client;
import dev.julioperez.littleTree.provider.domain.dto.CreateProviderRequest;
import dev.julioperez.littleTree.provider.domain.dto.UpdateProviderRequest;
import dev.julioperez.littleTree.provider.domain.model.Provider;
import dev.julioperez.littleTree.provider.domain.port.createProvider.CreateProviderInputPort;
import dev.julioperez.littleTree.provider.domain.port.getProvider.GetProviderInputPort;
import dev.julioperez.littleTree.provider.domain.port.updateProvider.UpdateProviderInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/provider")
@Slf4j
@CrossOrigin(origins = "http://localhost:3001")
public class ProviderController {

    private final CreateProviderInputPort createProviderInputPort;
    private final GetProviderInputPort getProviderInputPort;
    private final UpdateProviderInputPort updateProviderInputPort;

    public ProviderController(CreateProviderInputPort createProviderInputPort, GetProviderInputPort getProviderInputPort, UpdateProviderInputPort updateProviderInputPort) {
        this.createProviderInputPort = createProviderInputPort;
        this.getProviderInputPort = getProviderInputPort;
        this.updateProviderInputPort = updateProviderInputPort;
    }

    @PutMapping("/create")
    public ResponseEntity<Provider> createProvider(@RequestBody CreateProviderRequest createProviderRequest){
        Provider provider = createProviderInputPort.createProvider(createProviderRequest);
        return new ResponseEntity<>(provider, HttpStatus.CREATED);
    }

    @PutMapping("/get")
    public ResponseEntity<List<Provider>> getAllProvider(){
        List<Provider> providers = getProviderInputPort.getProviders();
        HttpStatus httpStatus = providers.isEmpty()
                ? HttpStatus.NO_CONTENT
                : HttpStatus.FOUND;
        return new ResponseEntity<>(providers, httpStatus);
    }

    @PutMapping("/get/{id}")
    public ResponseEntity<Optional<Provider>> getProviderById(@PathVariable String id){
        Optional<Provider> providers = getProviderInputPort.getProviderById(id);
        HttpStatus httpStatus = providers.isEmpty()
                ? HttpStatus.NO_CONTENT
                : HttpStatus.FOUND;
        return new ResponseEntity<>(providers, httpStatus);
    }

    @PutMapping("/update")
    public ResponseEntity<Provider> updateProvider(@RequestBody UpdateProviderRequest updateProviderRequest){
        Provider provider = updateProviderInputPort.updateProvider(updateProviderRequest);
        return new ResponseEntity<>(provider, HttpStatus.OK);
    }

}
