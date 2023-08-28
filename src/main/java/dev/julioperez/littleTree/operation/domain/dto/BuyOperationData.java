package dev.julioperez.littleTree.operation.domain.dto;

public record BuyOperationData(String operationType, String currencyMultiBox, Float buyPrice, Float quantity, Float percent) {
}
