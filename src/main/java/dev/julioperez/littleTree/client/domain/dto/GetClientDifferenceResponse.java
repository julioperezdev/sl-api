package dev.julioperez.littleTree.client.domain.dto;

import java.util.Date;

public record GetClientDifferenceResponse(String id, Date createdAt,Date updatedAt, String clientName, Float amount, String description, String differenceType, String differenceStatus) {
}
