package dev.julioperez.littleTree.provider.application.createProvider.service;

import dev.julioperez.littleTree.provider.domain.dto.CreateProviderRequest;
import dev.julioperez.littleTree.provider.domain.model.Provider;
import dev.julioperez.littleTree.provider.domain.port.createProvider.CreateProvider;
import dev.julioperez.littleTree.provider.domain.port.createProvider.CreateProviderOutputPort;
import dev.julioperez.littleTree.provider.domain.port.providerMapper.ProviderMapper;

public class CreateProviderService implements CreateProvider {
    private final CreateProviderOutputPort createProviderOutputPort;
    private final ProviderMapper providerMapper;

    public CreateProviderService(CreateProviderOutputPort createProviderOutputPort, ProviderMapper providerMapper) {
        this.createProviderOutputPort = createProviderOutputPort;
        this.providerMapper = providerMapper;
    }

    @Override
    public Provider createProvider(CreateProviderRequest createProviderRequest) {
        Provider provider = providerMapper.toProviderModel(createProviderRequest);
        return createProviderOutputPort.createProvider(provider);
    }
}
