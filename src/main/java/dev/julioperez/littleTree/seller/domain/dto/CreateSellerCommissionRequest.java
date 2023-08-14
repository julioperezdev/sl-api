package dev.julioperez.littleTree.seller.domain.dto;

public record CreateSellerCommissionRequest(Float pesos, Float quantity, Float profit, String sellerId, String sellerCommissionStatus) {
}
