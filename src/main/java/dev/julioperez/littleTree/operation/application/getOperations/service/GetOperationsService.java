package dev.julioperez.littleTree.operation.application.getOperations.service;

import dev.julioperez.littleTree.client.domain.port.getClients.GetClients;
import dev.julioperez.littleTree.operation.domain.dto.GetBuyOperationResponse;
import dev.julioperez.littleTree.operation.domain.dto.GetDoneOperationToShowReserve;
import dev.julioperez.littleTree.operation.domain.model.buyOperation.BuyOperation;
import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperation;
import dev.julioperez.littleTree.operation.domain.port.getOperations.GetOperations;
import dev.julioperez.littleTree.operation.domain.port.getOperations.GetOperationsOutputPort;

import java.util.*;
import java.util.stream.Collectors;

public class GetOperationsService implements GetOperations {
    private final GetOperationsOutputPort getOperationsOutputPort;
    private final GetClients getClients;

    public GetOperationsService(GetOperationsOutputPort getOperationsOutputPort, GetClients getClients) {
        this.getOperationsOutputPort = getOperationsOutputPort;
        this.getClients = getClients;
    }

    @Override
    public List<BuyOperation> getBuyOperations() {
        return getOperationsOutputPort.getBuyOperations();
    }

    @Override
    public List<GetBuyOperationResponse> getPendingBuyOperations() {
        List<BuyOperation> buyOperations = getOperationsOutputPort.getPendingBuyOperations().stream().sorted(Comparator.comparing(BuyOperation::getUpdatedAt).reversed()).toList();
        List<String> clientIdList = buyOperations.stream().map(BuyOperation::getClientId).distinct().toList();
        Map<String, String> clientsNameById = getClients.getClientsNameById(clientIdList);
        List<GetBuyOperationResponse> getBuyOperationResponses = new ArrayList<>();
        buyOperations.forEach(particular->{
            String clientName = clientsNameById.get(particular.getClientId());
            GetBuyOperationResponse getClientDifferenceDto = mapToGetBuyOperationResponses(particular, clientName);
            getBuyOperationResponses.add(getClientDifferenceDto);
        });
        return getBuyOperationResponses;
    }

    @Override
    public List<GetBuyOperationResponse> getDoneBuyOperations() {
        List<BuyOperation> buyOperations = getOperationsOutputPort.getDoneBuyOperations().stream().sorted(Comparator.comparing(BuyOperation::getUpdatedAt).reversed()).toList();
        List<String> clientIdList = buyOperations.stream().map(BuyOperation::getClientId).distinct().toList();
        Map<String, String> clientsNameById = getClients.getClientsNameById(clientIdList);
        List<GetBuyOperationResponse> getBuyOperationResponses = new ArrayList<>();
        buyOperations.forEach(particular->{
            String clientName = clientsNameById.get(particular.getClientId());
            GetBuyOperationResponse getClientDifferenceDto = mapToGetBuyOperationResponses(particular, clientName);
            getBuyOperationResponses.add(getClientDifferenceDto);
        });
        return getBuyOperationResponses;
    }

    @Override
    public List<GetDoneOperationToShowReserve> getDoneBuyOperationsByCurrency(String currency) {
        return getOperationsOutputPort.getDoneBuyOperations().stream().sorted(Comparator.comparing(BuyOperation::getCreatedAt).reversed()).filter(particular -> particular.getCurrencyMultiBox().equalsIgnoreCase(currency)).map(this::mapToGetDoneOperationToShowReserve).toList();
    }

    private GetBuyOperationResponse mapToGetBuyOperationResponses(BuyOperation buyOperation, String clientName){
        return new GetBuyOperationResponse(
                buyOperation.getId(),
                buyOperation.getCreatedAt(),
                buyOperation.getUpdatedAt(),
                clientName,
                buyOperation.getCurrencyMultiBox(),
                buyOperation.getPrice(),
                buyOperation.getQuantity(),
                buyOperation.getTotal());
    }

    private GetDoneOperationToShowReserve mapToGetDoneOperationToShowReserve(BuyOperation buyOperation){
        return new GetDoneOperationToShowReserve(
                buyOperation.getId(),
                buyOperation.getCreatedAt(),
                //buyOperation.getUpdatedAt(),
                buyOperation.getPrice(),
                buyOperation.getReserve());
    }

    @Override
    public Optional<BuyOperation> getBuyOperationById(String operationId) {
        return getBuyOperations().stream()
                .filter(operation -> operation.getId().equals(operationId))
                .findFirst();
    }

    @Override
    public List<SellOperation> getSellOperations() {
        return getOperationsOutputPort.getSellOperations().stream().sorted(Comparator.comparing(SellOperation::getUpdatedAt).reversed()).collect(Collectors.toList());
    }

    @Override
    public Optional<SellOperation> getSellOperationById(String operationId) {
        return getSellOperations().stream()
                .filter(operation -> operation.getId().equals(operationId))
                .findFirst();
    }
}
