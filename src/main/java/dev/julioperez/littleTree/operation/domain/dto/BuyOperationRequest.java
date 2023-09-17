package dev.julioperez.littleTree.operation.domain.dto;

import java.util.List;

public record BuyOperationRequest(boolean hasOfficeCheck, String clientId, List<BuyOperationData> buyOperationData) {
}
