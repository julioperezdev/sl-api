package dev.julioperez.littleTree.client.clientDifference.application.getClientDifference.delivery;

import dev.julioperez.littleTree.client.clientDifference.domain.dto.GetClientDifferenceResponse;
import dev.julioperez.littleTree.client.clientDifference.domain.model.ClientDifference;
import dev.julioperez.littleTree.client.clientDifference.domain.port.getClientDifference.GetClientDifference;
import dev.julioperez.littleTree.client.clientDifference.domain.port.getClientDifference.GetClientDifferenceInputPort;

import java.util.List;
import java.util.Optional;

public class GetClientDifferenceDelivery implements GetClientDifferenceInputPort {
    private final GetClientDifference getClientDifference;

    public GetClientDifferenceDelivery(GetClientDifference getClientDifference) {
        this.getClientDifference = getClientDifference;
    }

    @Override
    public List<ClientDifference> getClientDifference() {
        return getClientDifference.getClientDifference();
    }

    @Override
    public List<GetClientDifferenceResponse> getClientDifferenceDto() throws Exception {
        return getClientDifference.getClientDifferenceDto();
    }


    @Override
    public Optional<ClientDifference> getOptionalClientDifferenceById(String id) {
        return getClientDifference.getOptionalClientDifferenceById(id);
    }

    @Override
    public Optional<GetClientDifferenceResponse> getClientDifferenceById(String id) throws Exception {
        return getClientDifference.getClientDifferenceById(id);
    }

    @Override
    public boolean hasClientDifferenceByClientId(String clientId) {
        return getClientDifference.hasClientDifferenceByClientId(clientId);
    }
}
