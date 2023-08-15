package dev.julioperez.littleTree.provider.application.updateProvider.delivery;

import dev.julioperez.littleTree.provider.domain.dto.UpdateProviderRequest;
import dev.julioperez.littleTree.provider.domain.model.Provider;
import dev.julioperez.littleTree.provider.domain.port.updateProvider.UpdateProvider;
import dev.julioperez.littleTree.provider.domain.port.updateProvider.UpdateProviderInputPort;

public class UpdateProviderDelivery implements UpdateProviderInputPort {
    private final UpdateProvider updateProvider;

    public UpdateProviderDelivery(UpdateProvider updateProvider) {
        this.updateProvider = updateProvider;
    }

    @Override
    public Provider updateProvider(UpdateProviderRequest updateProviderRequest) {
        return updateProvider.updateProvider(updateProviderRequest);
    }
}
