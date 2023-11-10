package dev.julioperez.littleTree.seller.domain.dto;

public record CreateSellerCommissionRequest(String operationId, Float total, Float profit, Float quantity, Float pesos, String sellerId, String sellerCommissionStatus) {
}
