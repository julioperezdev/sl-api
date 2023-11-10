package dev.julioperez.littleTree.seller.sellerCommission.domain.dto;

public record SellerCommissionResponseDto(String id, String date, String sellerName, Float pesos, Float quantity, Float sellerProfit, String operationId, String status) {
}
