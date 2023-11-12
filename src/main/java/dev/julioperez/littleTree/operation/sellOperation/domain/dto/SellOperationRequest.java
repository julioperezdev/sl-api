package dev.julioperez.littleTree.operation.sellOperation.domain.dto;

import java.util.List;

public record SellOperationRequest(String id,String clientId, List<SellOperationData> sellOperationData) {
}
