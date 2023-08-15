package dev.julioperez.littleTree.provider.application.createProvider.adapter;

import dev.julioperez.littleTree.provider.domain.model.Provider;
import dev.julioperez.littleTree.provider.domain.port.createProvider.CreateProviderOutputPort;
import dev.julioperez.littleTree.provider.domain.port.providerMapper.ProviderMapper;
import dev.julioperez.littleTree.provider.infrastructure.repository.dao.ProviderDao;
import dev.julioperez.littleTree.provider.infrastructure.repository.entity.ProviderEntity;

public class CreateProviderAdapterRepository implements CreateProviderOutputPort {
    private final ProviderDao providerDao;
    private final ProviderMapper providerMapper;

    public CreateProviderAdapterRepository(ProviderDao providerDao, ProviderMapper providerMapper) {
        this.providerDao = providerDao;
        this.providerMapper = providerMapper;
    }

    @Override
    public Provider createProvider(Provider provider) {
        ProviderEntity providerEntity = providerMapper.toProviderEntity(provider);
        providerDao.save(providerEntity);
        return providerMapper.toProviderModel(providerEntity);
    }
}
