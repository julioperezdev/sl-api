package dev.julioperez.littleTree.provider.domain.port.getProvider;

import dev.julioperez.littleTree.provider.domain.model.Provider;

import java.util.List;

public interface GetProviderOutputPort {
    List<Provider> getProviders();
}
