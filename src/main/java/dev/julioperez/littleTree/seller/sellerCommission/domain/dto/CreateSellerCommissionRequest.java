package dev.julioperez.littleTree.seller.sellerCommission.domain.dto;

public record CreateSellerCommissionRequest(String operationId, Float total, Float profit, Float quantity, Float pesos, String sellerId, String sellerCommissionStatus) {
}
