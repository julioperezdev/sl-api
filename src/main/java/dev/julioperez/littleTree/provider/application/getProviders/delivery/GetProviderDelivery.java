package dev.julioperez.littleTree.provider.application.getProviders.delivery;

import dev.julioperez.littleTree.provider.domain.model.Provider;
import dev.julioperez.littleTree.provider.domain.port.getProvider.GetProvider;
import dev.julioperez.littleTree.provider.domain.port.getProvider.GetProviderInputPort;

import java.util.List;
import java.util.Optional;

public class GetProviderDelivery implements GetProviderInputPort {
    private final GetProvider getProvider;

    public GetProviderDelivery(GetProvider getProvider) {
        this.getProvider = getProvider;
    }

    @Override
    public List<Provider> getProviders() {
        return getProvider.getProviders();
    }

    @Override
    public Optional<Provider> getProviderById(String id) {
        return getProvider.getProviderById(id);
    }
}
