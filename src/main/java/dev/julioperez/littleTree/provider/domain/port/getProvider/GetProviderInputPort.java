package dev.julioperez.littleTree.provider.domain.port.getProvider;

import dev.julioperez.littleTree.provider.domain.model.Provider;

import java.util.List;
import java.util.Optional;

public interface GetProviderInputPort {
    List<Provider> getProviders();
    Optional<Provider> getProviderById(String id);
}
