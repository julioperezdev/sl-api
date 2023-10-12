package dev.julioperez.littleTree.provider.application.createProvider.service;

import dev.julioperez.littleTree.client.domain.model.Client;
import dev.julioperez.littleTree.provider.domain.dto.CreateProviderRequest;
import dev.julioperez.littleTree.provider.domain.model.Provider;
import dev.julioperez.littleTree.provider.domain.port.createProvider.CreateProvider;
import dev.julioperez.littleTree.provider.domain.port.createProvider.CreateProviderOutputPort;
import dev.julioperez.littleTree.provider.domain.port.getProvider.GetProvider;
import dev.julioperez.littleTree.provider.domain.port.providerMapper.ProviderMapper;

import java.util.Optional;

public class CreateProviderService implements CreateProvider {
    private final CreateProviderOutputPort createProviderOutputPort;
    private final ProviderMapper providerMapper;
    private final GetProvider getProvider;

    public CreateProviderService(CreateProviderOutputPort createProviderOutputPort, ProviderMapper providerMapper, GetProvider getProvider) {
        this.createProviderOutputPort = createProviderOutputPort;
        this.providerMapper = providerMapper;
        this.getProvider = getProvider;
    }

    @Override
    public Provider createProvider(CreateProviderRequest createProviderRequest) {
        Optional<Provider> optionalProviderByName = getProvider.getOptionalProviderByName(createProviderRequest.name().trim());
        if(optionalProviderByName.isPresent()) throw new IllegalArgumentException(String.format("%s name exist with registered provider",createProviderRequest.name().trim()));
        Provider provider = providerMapper.toProviderModel(createProviderRequest);
        return createProviderOutputPort.createProvider(provider);
    }
}
