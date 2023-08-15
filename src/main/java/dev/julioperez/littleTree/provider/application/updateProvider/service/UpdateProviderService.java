package dev.julioperez.littleTree.provider.application.updateProvider.service;

import dev.julioperez.littleTree.provider.domain.dto.UpdateProviderRequest;
import dev.julioperez.littleTree.provider.domain.model.Provider;
import dev.julioperez.littleTree.provider.domain.port.getProvider.GetProvider;
import dev.julioperez.littleTree.provider.domain.port.providerMapper.ProviderMapper;
import dev.julioperez.littleTree.provider.domain.port.updateProvider.UpdateProvider;
import dev.julioperez.littleTree.provider.domain.port.updateProvider.UpdateProviderOutputPort;

import java.util.Optional;

public class UpdateProviderService implements UpdateProvider {
    private final UpdateProviderOutputPort updateProviderOutputPort;
    private final GetProvider getProvider;
    private final ProviderMapper providerMapper;

    public UpdateProviderService(UpdateProviderOutputPort updateProviderOutputPort, GetProvider getProvider, ProviderMapper providerMapper) {
        this.updateProviderOutputPort = updateProviderOutputPort;
        this.getProvider = getProvider;
        this.providerMapper = providerMapper;
    }

    @Override
    public Provider updateProvider(UpdateProviderRequest updateProviderRequest) {
        Optional<Provider> providerById = getProvider.getProviderById(updateProviderRequest.id());
        if(providerById.isEmpty()) throw new IllegalArgumentException(String.format("%s id dont exist as Provider", updateProviderRequest.id()));
        Provider provider = providerMapper.toProviderModel(providerById.get(), updateProviderRequest);
        return updateProviderOutputPort.updateProvider(provider);
    }
}
