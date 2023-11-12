package dev.julioperez.littleTree.client.clientDifference.application.getClientDifference.service;

import dev.julioperez.littleTree.client.clientDifference.domain.dto.GetClientDifferenceResponse;
import dev.julioperez.littleTree.client.clientDifference.domain.model.ClientDifference;
import dev.julioperez.littleTree.client.clientDifference.domain.port.getClientDifference.GetClientDifference;
import dev.julioperez.littleTree.client.clientDifference.domain.port.getClientDifference.GetClientDifferenceOutputPort;
import dev.julioperez.littleTree.client.client.domain.port.getClients.GetClients;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
public class GetClientDifferenceService implements GetClientDifference {
    private final GetClientDifferenceOutputPort getClientDifferenceOutputPort;
    private final GetClients getClients;

    public GetClientDifferenceService(GetClientDifferenceOutputPort getClientDifferenceOutputPort, GetClients getClients) {
        this.getClientDifferenceOutputPort = getClientDifferenceOutputPort;
        this.getClients = getClients;
    }
    @Override
    public List<ClientDifference> getClientDifference() {
        return getClientDifferenceOutputPort.getClientDifference();
    }

    @Override
    public List<GetClientDifferenceResponse> getClientDifferenceDto() {
        List<ClientDifference> clientDifference = getClientDifferenceOutputPort.getClientDifference();
        List<String> clientIdList = clientDifference.stream().map(ClientDifference::getClientId).distinct().toList();
        Map<String, String> clientsNameById = getClients.getClientsNameById(clientIdList);
        List<GetClientDifferenceResponse> getClientDifferenceResponses = new ArrayList<>();
        clientDifference.forEach(particular->{
            String clientName = clientsNameById.get(particular.getClientId());
            GetClientDifferenceResponse getClientDifferenceDto = mapToGetClientDifferenceResponse(particular, clientName);
            getClientDifferenceResponses.add(getClientDifferenceDto);
        });
        return getClientDifferenceResponses;
    }

    private GetClientDifferenceResponse mapToGetClientDifferenceResponse(ClientDifference clientDifference, String clientName){
        return new GetClientDifferenceResponse(
                clientDifference.getId(),
                clientDifference.getCreatedAt(),
                clientDifference.getUpdatedAt(),
                clientName,
                clientDifference.getAmount(),
                clientDifference.getDescription(),
                clientDifference.getDifferenceType(),
                clientDifference.getDifferenceStatus());
    }
    @Override
    public Optional<ClientDifference> getOptionalClientDifferenceById(String id) {
        List<ClientDifference> allClientDifference = getClientDifference();
        return  allClientDifference.stream()
                .filter(particularClientDifference -> particularClientDifference.getId().equals(id))
                .findFirst();
    }

    public boolean hasClientDifferenceByClientId(String clientId) {
        List<ClientDifference> allClientDifference = getClientDifference();
        return  allClientDifference.stream()
                .anyMatch(particularClientDifference -> particularClientDifference.getClientId().equals(clientId));
    }

    @Override
    public Optional<GetClientDifferenceResponse> getClientDifferenceById(String id) throws Exception {
        List<ClientDifference> allClientDifference = getClientDifference();
        ClientDifference clientDifference = allClientDifference.stream()
                .filter(particularClientDifference -> particularClientDifference.getId().equals(id))
                .findFirst().orElse(null);
        if(clientDifference == null) {
            log.error(String.format("Error because dont found client difference with id %s ", id));
            return Optional.empty();}
        String clientName = getClients.getOptionalClientNameById(clientDifference.getClientId()).orElse(null);
        if(clientName == null) {
            log.error(String.format("Error because dont found client with id %s to return client difference dto", id));
            return Optional.empty();}
        return Optional.of(new GetClientDifferenceResponse(
                clientDifference.getId(),
                clientDifference.getCreatedAt(),
                clientDifference.getUpdatedAt(),
                clientName,
                clientDifference.getAmount(),
                clientDifference.getDescription(),
                clientDifference.getDifferenceType(),
                clientDifference.getDifferenceStatus()));
    }
}
