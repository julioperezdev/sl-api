package dev.julioperez.littleTree.operation.shared.domain.dto;

import java.util.Date;

public record GetOperationResponseDto(String id, Date createdAt, Date updatedAt, String clientName, String currencyMultiBox, Float price, Float quantity, Float total) {
}
