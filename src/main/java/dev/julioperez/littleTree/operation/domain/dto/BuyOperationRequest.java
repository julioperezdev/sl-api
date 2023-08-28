package dev.julioperez.littleTree.operation.domain.dto;

import java.util.List;

public record BuyOperationRequest(boolean hasOfficeCheck, String clientId, String phone, List<BuyOperationData> buyOperationData) {
}
