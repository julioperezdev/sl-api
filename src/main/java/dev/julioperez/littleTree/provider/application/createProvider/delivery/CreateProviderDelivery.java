package dev.julioperez.littleTree.provider.application.createProvider.delivery;

import dev.julioperez.littleTree.provider.domain.dto.CreateProviderRequest;
import dev.julioperez.littleTree.provider.domain.model.Provider;
import dev.julioperez.littleTree.provider.domain.port.createProvider.CreateProvider;
import dev.julioperez.littleTree.provider.domain.port.createProvider.CreateProviderInputPort;

public class CreateProviderDelivery implements CreateProviderInputPort {
    private final CreateProvider createProvider;

    public CreateProviderDelivery(CreateProvider createProvider) {
        this.createProvider = createProvider;
    }

    @Override
    public Provider createProvider(CreateProviderRequest createProviderRequest) {
        return createProvider.createProvider(createProviderRequest);
    }
}
