package dev.julioperez.littleTree.client.domain.port.getClientDifference;

import dev.julioperez.littleTree.client.domain.dto.GetClientDifferenceResponse;
import dev.julioperez.littleTree.client.domain.model.ClientDifference;

import java.util.List;
import java.util.Optional;

public interface GetClientDifference {
    List<ClientDifference> getClientDifference();
    List<GetClientDifferenceResponse> getClientDifferenceDto();
    Optional<ClientDifference> getOptionalClientDifferenceById(String id);
    Optional<GetClientDifferenceResponse> getClientDifferenceById(String id) throws Exception;

    boolean hasClientDifferenceByClientId(String clientId);
}
