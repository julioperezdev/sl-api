package dev.julioperez.littleTree.operation.buyOperation.domain.dto;

import java.util.List;

public record BuyOperationRequest(String id,boolean hasOfficeCheck, String clientId, List<BuyOperationData> buyOperationData) {
}
