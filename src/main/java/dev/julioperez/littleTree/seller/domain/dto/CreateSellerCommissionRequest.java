package dev.julioperez.littleTree.seller.domain.dto;

public record CreateSellerCommissionRequest(String operationId, Float total, Float profit, String sellerId, String sellerCommissionStatus) {
}
