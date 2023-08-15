package dev.julioperez.littleTree.provider.application.updateProvider.adapter;

import dev.julioperez.littleTree.provider.domain.model.Provider;
import dev.julioperez.littleTree.provider.domain.port.providerMapper.ProviderMapper;
import dev.julioperez.littleTree.provider.domain.port.updateProvider.UpdateProviderOutputPort;
import dev.julioperez.littleTree.provider.infrastructure.repository.dao.ProviderDao;
import dev.julioperez.littleTree.provider.infrastructure.repository.entity.ProviderEntity;

public class UpdateProviderAdapterRepository implements UpdateProviderOutputPort {
    private final ProviderDao providerDao;
    private final ProviderMapper providerMapper;

    public UpdateProviderAdapterRepository(ProviderDao providerDao, ProviderMapper providerMapper) {
        this.providerDao = providerDao;
        this.providerMapper = providerMapper;
    }

    @Override
    public Provider updateProvider(Provider provider) {
        ProviderEntity providerEntity = providerMapper.toProviderEntity(provider);
        providerDao.save(providerEntity);
        return providerMapper.toProviderModel(providerEntity);
    }
}
