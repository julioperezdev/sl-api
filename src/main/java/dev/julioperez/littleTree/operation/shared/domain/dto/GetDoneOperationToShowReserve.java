package dev.julioperez.littleTree.operation.shared.domain.dto;

import java.util.Date;

public record GetDoneOperationToShowReserve(String id, Date updatedAt, Float buyPrice, Float reserve) {
}
