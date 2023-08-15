package dev.julioperez.littleTree.provider.application.getProviders.adapter;

import dev.julioperez.littleTree.provider.domain.model.Provider;
import dev.julioperez.littleTree.provider.domain.port.getProvider.GetProviderOutputPort;
import dev.julioperez.littleTree.provider.domain.port.providerMapper.ProviderMapper;
import dev.julioperez.littleTree.provider.infrastructure.repository.dao.ProviderDao;
import dev.julioperez.littleTree.provider.infrastructure.repository.entity.ProviderEntity;

import java.util.List;

public class GetProviderAdapterRepository implements GetProviderOutputPort {
    private final ProviderDao providerDao;
    private final ProviderMapper providerMapper;

    public GetProviderAdapterRepository(ProviderDao providerDao, ProviderMapper providerMapper) {
        this.providerDao = providerDao;
        this.providerMapper = providerMapper;
    }

    @Override
    public List<Provider> getProviders() {
        List<ProviderEntity> providerEntities = providerDao.findAll();
        return providerMapper.toProvidersModel(providerEntities);
    }
}
