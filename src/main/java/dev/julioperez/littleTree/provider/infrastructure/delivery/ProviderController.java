package dev.julioperez.littleTree.provider.infrastructure.delivery;

import dev.julioperez.littleTree.client.domain.model.Client;
import dev.julioperez.littleTree.provider.domain.dto.CreateProviderRequest;
import dev.julioperez.littleTree.provider.domain.dto.UpdateProviderRequest;
import dev.julioperez.littleTree.provider.domain.model.Provider;
import dev.julioperez.littleTree.provider.domain.port.createProvider.CreateProviderInputPort;
import dev.julioperez.littleTree.provider.domain.port.getProvider.GetProviderInputPort;
import dev.julioperez.littleTree.provider.domain.port.updateProvider.UpdateProviderInputPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/provider")
public class ProviderController {

    private final CreateProviderInputPort createProviderInputPort;
    private final GetProviderInputPort getProviderInputPort;
    private final UpdateProviderInputPort updateProviderInputPort;

    public ProviderController(CreateProviderInputPort createProviderInputPort, GetProviderInputPort getProviderInputPort, UpdateProviderInputPort updateProviderInputPort) {
        this.createProviderInputPort = createProviderInputPort;
        this.getProviderInputPort = getProviderInputPort;
        this.updateProviderInputPort = updateProviderInputPort;
    }

    @PostMapping("/create")
    public ResponseEntity<Provider> createProvider(@RequestBody CreateProviderRequest createProviderRequest){
        Provider provider = createProviderInputPort.createProvider(createProviderRequest);
        return new ResponseEntity<>(provider, HttpStatus.CREATED);
    }

    @PostMapping("/get")
    public ResponseEntity<List<Provider>> getAllProvider(){
        List<Provider> providers = getProviderInputPort.getProviders();
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
