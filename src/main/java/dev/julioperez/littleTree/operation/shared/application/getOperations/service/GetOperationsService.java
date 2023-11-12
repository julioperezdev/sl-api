package dev.julioperez.littleTree.operation.shared.application.getOperations.service;

import dev.julioperez.littleTree.client.client.domain.port.getClients.GetClients;
import dev.julioperez.littleTree.operation.shared.domain.dto.GetBuyAndSellOperationResponseDto;
import dev.julioperez.littleTree.operation.shared.domain.dto.GetOperationResponseDto;
import dev.julioperez.littleTree.operation.shared.domain.dto.GetDoneOperationToShowReserve;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationStatus;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;
import dev.julioperez.littleTree.operation.shared.domain.port.getOperations.GetOperations;
import dev.julioperez.littleTree.operation.shared.domain.port.getOperations.GetOperationsOutputPort;

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
    public GetBuyAndSellOperationResponseDto getPendingBuyAndSellOperations() {
        List<GetOperationResponseDto> pendingBuyOperation = getPendingBuyOperation(OperationStatus.PENDING);
        List<GetOperationResponseDto> pendingSellOperation = getPendingSellOperation(OperationStatus.PENDING);
        return new GetBuyAndSellOperationResponseDto(pendingBuyOperation, pendingSellOperation);
    }

    @Override
    public GetBuyAndSellOperationResponseDto getDoneBuyAndSellOperations() {
        List<GetOperationResponseDto> pendingBuyOperation = getPendingBuyOperation(OperationStatus.DONE);
        List<GetOperationResponseDto> pendingSellOperation = getPendingSellOperation(OperationStatus.DONE);
        return new GetBuyAndSellOperationResponseDto(pendingBuyOperation, pendingSellOperation);
    }

    private List<GetOperationResponseDto> getPendingBuyOperation(OperationStatus operationStatus){
        List<BuyOperation> buyOperations = getOperationsOutputPort.getBuyOperationsByStatus(operationStatus).stream().sorted(Comparator.comparing(BuyOperation::getUpdatedAt).reversed()).toList();
        List<String> clientIdList = buyOperations.stream().map(BuyOperation::getClientId).distinct().toList();
        Map<String, String> clientsNameById = getClients.getClientsNameById(clientIdList);
        List<GetOperationResponseDto> getBuyOperationResponses = new ArrayList<>();
        buyOperations.forEach(particular->{
            String clientName = clientsNameById.get(particular.getClientId());
            GetOperationResponseDto getClientDifferenceDto = mapToGetBuyOperationResponses(particular, clientName);
            getBuyOperationResponses.add(getClientDifferenceDto);
        });
        return getBuyOperationResponses;
    }

    private List<GetOperationResponseDto> getPendingSellOperation(OperationStatus operationStatus){
        List<SellOperation> sellOperations = getOperationsOutputPort.geSellOperationsByStatus(operationStatus).stream().sorted(Comparator.comparing(SellOperation::getUpdatedAt).reversed()).toList();
        List<String> clientIdList = sellOperations.stream().map(SellOperation::getClientId).distinct().toList();
        Map<String, String> clientsNameById = getClients.getClientsNameById(clientIdList);
        List<GetOperationResponseDto> getSellOperationResponses = new ArrayList<>();
        sellOperations.forEach(particular->{
            String clientName = clientsNameById.get(particular.getClientId());
            GetOperationResponseDto getClientDifferenceDto = mapToGetSellOperationResponses(particular, clientName);
            getSellOperationResponses.add(getClientDifferenceDto);
        });
        return getSellOperationResponses;
    }

    @Override
    public List<GetOperationResponseDto> getDoneBuyOperations() {
        List<BuyOperation> buyOperations = getOperationsOutputPort.getDoneBuyOperations().stream().sorted(Comparator.comparing(BuyOperation::getUpdatedAt).reversed()).toList();
        List<String> clientIdList = buyOperations.stream().map(BuyOperation::getClientId).distinct().toList();
        Map<String, String> clientsNameById = getClients.getClientsNameById(clientIdList);
        List<GetOperationResponseDto> getBuyOperationResponses = new ArrayList<>();
        buyOperations.forEach(particular->{
            String clientName = clientsNameById.get(particular.getClientId());
            GetOperationResponseDto getClientDifferenceDto = mapToGetBuyOperationResponses(particular, clientName);
            getBuyOperationResponses.add(getClientDifferenceDto);
        });
        return getBuyOperationResponses;
    }

    @Override
    public List<GetDoneOperationToShowReserve> getDoneBuyOperationsByCurrency(String currency) {
        return getOperationsOutputPort.getDoneBuyOperations().stream().sorted(Comparator.comparing(BuyOperation::getCreatedAt).reversed()).filter(particular -> particular.getCurrencyMultiBox().equalsIgnoreCase(currency) && particular.getReserve() > 0).map(this::mapToGetDoneOperationToShowReserve).toList();
    }

    private GetOperationResponseDto mapToGetBuyOperationResponses(BuyOperation buyOperation, String clientName){
        return new GetOperationResponseDto(
                buyOperation.getId(),
                buyOperation.getCreatedAt(),
                buyOperation.getUpdatedAt(),
                clientName,
                buyOperation.getCurrencyMultiBox(),
                buyOperation.getPrice(),
                buyOperation.getQuantity(),
                buyOperation.getTotal());
    }

    private GetOperationResponseDto mapToGetSellOperationResponses(SellOperation sellOperation, String clientName){
        return new GetOperationResponseDto(
                sellOperation.getId(),
                sellOperation.getCreatedAt(),
                sellOperation.getUpdatedAt(),
                clientName,
                sellOperation.getCurrencyMultiBox(),
                sellOperation.getPrice(),
                sellOperation.getQuantity(),
                sellOperation.getTotal());
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
