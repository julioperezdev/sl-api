package dev.julioperez.littleTree.operation.domain.dto;

import java.util.Date;

public record GetDoneOperationToShowReserve(String id, Date updatedAt, Float buyPrice, Float reserve) {
}
