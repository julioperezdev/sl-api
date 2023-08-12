package dev.julioperez.littleTree.client.domain.dto;


public record CreateClientDifferenceRequest(String clientId,Float amount, String description, String differenceType, String differenceStatus) {
}
