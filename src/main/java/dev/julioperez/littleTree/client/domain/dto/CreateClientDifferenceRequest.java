package dev.julioperez.littleTree.client.domain.dto;


public record CreateClientDifferenceRequest(String id, String clientId,Float amount, String description, String differenceType) {
}
