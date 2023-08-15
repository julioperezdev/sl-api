package dev.julioperez.littleTree.provider.domain.port.providerMapper;

import dev.julioperez.littleTree.client.domain.dto.CreateClientRequest;
import dev.julioperez.littleTree.client.domain.dto.UpdateClientRequest;
import dev.julioperez.littleTree.client.domain.model.Client;
import dev.julioperez.littleTree.client.infrastructure.repository.entity.ClientEntity;
import dev.julioperez.littleTree.provider.domain.dto.CreateProviderRequest;
import dev.julioperez.littleTree.provider.domain.dto.UpdateProviderRequest;
import dev.julioperez.littleTree.provider.domain.model.Provider;
import dev.julioperez.littleTree.provider.infrastructure.repository.entity.ProviderEntity;

import java.util.List;

public interface ProviderMapper {
    Provider toProviderModel(CreateProviderRequest createProviderRequest);
    Provider toProviderModel(Provider provider, UpdateProviderRequest updateProviderRequest);
    List<Provider> toProvidersModel(List<ProviderEntity> providerEntities);
    Provider toProviderModel(ProviderEntity providerEntity);
    ProviderEntity toProviderEntity(Provider provider);
}
