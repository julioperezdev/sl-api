package dev.julioperez.littleTree.provider.application.modelMapper;

import dev.julioperez.littleTree.provider.domain.dto.CreateProviderRequest;
import dev.julioperez.littleTree.provider.domain.dto.UpdateProviderRequest;
import dev.julioperez.littleTree.provider.domain.model.Provider;
import dev.julioperez.littleTree.provider.domain.port.providerMapper.ProviderMapper;
import dev.julioperez.littleTree.provider.infrastructure.repository.entity.ProviderEntity;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class ProviderModelMapper implements ProviderMapper {

    @Override
    public Provider toProviderModel(CreateProviderRequest createProviderRequest) {
        return new Provider(
                createProviderRequest.id(),
                createProviderRequest.name().trim(),
                createProviderRequest.phone(),
                createProviderRequest.address(),
                Date.from(Instant.now()),
                Date.from(Instant.now()));
    }

    @Override
    public Provider toProviderModel(Provider provider, UpdateProviderRequest updateProviderRequest) {
        return new Provider(
                provider.getId(),
                provider.getName(),
                updateProviderRequest.phone(),
                updateProviderRequest.address(),
                provider.getCreatedAt(),
                Date.from(Instant.now()));
    }

    @Override
    public List<Provider> toProvidersModel(List<ProviderEntity> providerEntities) {
        return providerEntities.stream().map(this::toProviderModel).toList();
    }

    @Override
    public Provider toProviderModel(ProviderEntity providerEntity) {
        return new Provider(
                providerEntity.getId(),
                providerEntity.getName(),
                providerEntity.getPhone(),
                providerEntity.getAddress(),
                providerEntity.getCreatedAt(),
                providerEntity.getUpdatedAt());
    }

    @Override
    public ProviderEntity toProviderEntity(Provider provider) {
        return new ProviderEntity(
                provider.getId(),
                provider.getName(),
                provider.getPhone(),
                provider.getAddress(),
                provider.getCreatedAt(),
                provider.getUpdatedAt());
    }
}
