package dev.julioperez.littleTree.operation.domain.dto;

public record SellOperationData(boolean hasSeller, String sellerId, Float sellerCommission, String operationType, String currencyMultiBox, Float buyPrice,String buyOperationId, Float sellPrice, Float quantityToSell) {
}
