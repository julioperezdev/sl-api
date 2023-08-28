package dev.julioperez.littleTree.operation.domain.dto;

public record SellOperationData(String operationType, String currencyMultiBox, Float buyPrice,String buyOperationId, Float sellPrice, Float quantityToSell) {
}
