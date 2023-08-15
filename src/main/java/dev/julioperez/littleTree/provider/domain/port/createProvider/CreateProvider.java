package dev.julioperez.littleTree.provider.domain.port.createProvider;

import dev.julioperez.littleTree.provider.domain.dto.CreateProviderRequest;
import dev.julioperez.littleTree.provider.domain.model.Provider;

public interface CreateProvider {
    Provider createProvider(CreateProviderRequest createProviderRequest);
}
