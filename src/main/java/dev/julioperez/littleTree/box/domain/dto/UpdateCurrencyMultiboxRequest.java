package dev.julioperez.littleTree.box.domain.dto;

public record UpdateCurrencyMultiboxRequest (String currencyBox, String operation, String operationId, Float quantity, Float pesosPrice){
}
