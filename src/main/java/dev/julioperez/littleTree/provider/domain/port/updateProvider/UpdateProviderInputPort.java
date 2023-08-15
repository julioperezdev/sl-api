package dev.julioperez.littleTree.provider.domain.port.updateProvider;

import dev.julioperez.littleTree.provider.domain.dto.UpdateProviderRequest;
import dev.julioperez.littleTree.provider.domain.model.Provider;

public interface UpdateProviderInputPort {
    Provider updateProvider(UpdateProviderRequest updateProviderRequest);
}
