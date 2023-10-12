package dev.julioperez.littleTree.provider.application.getProviders.service;

import dev.julioperez.littleTree.provider.domain.model.Provider;
import dev.julioperez.littleTree.provider.domain.port.getProvider.GetProvider;
import dev.julioperez.littleTree.provider.domain.port.getProvider.GetProviderOutputPort;
import dev.julioperez.littleTree.seller.domain.model.Seller;

import java.util.List;
import java.util.Optional;

public class GetProviderService implements GetProvider {
    private final GetProviderOutputPort getProviderOutputPort;

    public GetProviderService(GetProviderOutputPort getProviderOutputPort) {
        this.getProviderOutputPort = getProviderOutputPort;
    }

    @Override
    public List<Provider> getProviders() {
        return getProviderOutputPort.getProviders();
    }

    @Override
    public Optional<Provider> getProviderById(String id) {
        return getProviders().stream()
                .filter(provider -> provider.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Provider> getOptionalProviderByName(String name) {
        return getProviders().stream()
                .filter(provider -> provider.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
