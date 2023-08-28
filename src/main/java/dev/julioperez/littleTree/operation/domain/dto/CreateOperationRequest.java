package dev.julioperez.littleTree.operation.domain.dto;

public record CreateOperationRequest(String operationType, String clientName, String phone, String currencyType, String description) {
}
