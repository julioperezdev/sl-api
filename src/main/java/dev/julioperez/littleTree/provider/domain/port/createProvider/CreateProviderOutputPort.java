package dev.julioperez.littleTree.provider.domain.port.createProvider;

import dev.julioperez.littleTree.provider.domain.model.Provider;

public interface CreateProviderOutputPort {
    Provider createProvider(Provider provider);
}
