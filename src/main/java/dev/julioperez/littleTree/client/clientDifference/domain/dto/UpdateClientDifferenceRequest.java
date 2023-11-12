package dev.julioperez.littleTree.client.clientDifference.domain.dto;

public record UpdateClientDifferenceRequest(String id, Float amount, String description, String differenceType, String differenceStatus) {
}
