package dev.julioperez.littleTree.operation.domain.dto;

import java.util.List;

public record SellOperationRequest(String id,String clientId, List<SellOperationData> sellOperationData) {
}
