package dev.julioperez.littleTree.operation.domain.dto;

import java.util.List;

public record GetBuyAndSellOperationResponseDto(List<GetOperationResponseDto> buyOperation, List<GetOperationResponseDto> sellOperation) {
}
