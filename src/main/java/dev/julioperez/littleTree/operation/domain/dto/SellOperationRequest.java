package dev.julioperez.littleTree.operation.domain.dto;

import java.util.List;

public record SellOperationRequest(String id,String clientId, boolean hasSeller, String sellerId, Float sellerCommission, List<SellOperationData> sellOperationData) {
}
