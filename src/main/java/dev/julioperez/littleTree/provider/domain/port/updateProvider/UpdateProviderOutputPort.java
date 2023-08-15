package dev.julioperez.littleTree.provider.domain.port.updateProvider;

import dev.julioperez.littleTree.provider.domain.model.Provider;

public interface UpdateProviderOutputPort {
    Provider updateProvider(Provider provider);
}
