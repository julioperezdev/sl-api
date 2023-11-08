package dev.julioperez.littleTree.box.currencyBox.shared.domain.dto;

public record ManualTransactionRequest(String currencyBoxName, String manualOperationType, Float quantity) {
}
