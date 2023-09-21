package dev.julioperez.littleTree.operation.application.executeBuyOperation.service;

import dev.julioperez.littleTree.box.domain.port.updateCurrencyMultiBox.UpdateCurrencyMultiBox;
import dev.julioperez.littleTree.operation.application.generateTicket.service.GenerateTicketService;
import dev.julioperez.littleTree.operation.domain.enums.OperationStatus;
import dev.julioperez.littleTree.operation.domain.model.buyOperation.BuyOperation;
import dev.julioperez.littleTree.operation.domain.port.executeBuyOperation.ExecuteBuyOperation;
import dev.julioperez.littleTree.operation.domain.port.executeBuyOperation.ExecuteBuyOperationOutputPort;
import dev.julioperez.littleTree.operation.domain.port.generateTicket.GenerateTicket;
import dev.julioperez.littleTree.operation.domain.port.getOperations.GetOperations;

import java.util.Arrays;

public class ExecuteBuyOperationService implements ExecuteBuyOperation {
    private final ExecuteBuyOperationOutputPort executeBuyOperationOutputPort;
    private final GetOperations getOperations;
    private final UpdateCurrencyMultiBox updateCurrencyMultiBox;
    private final GenerateTicket generateTicket;

    public ExecuteBuyOperationService(ExecuteBuyOperationOutputPort executeBuyOperationOutputPort, GetOperations getOperations, UpdateCurrencyMultiBox updateCurrencyMultiBox, GenerateTicket generateTicket) {
        this.executeBuyOperationOutputPort = executeBuyOperationOutputPort;
        this.getOperations = getOperations;
        this.updateCurrencyMultiBox = updateCurrencyMultiBox;
        this.generateTicket = generateTicket;
    }

    @Override
    public boolean executeBuyOperation(String operationId) {
        BuyOperation buyOperation = getOperations.getBuyOperationById(operationId)
                .orElseThrow(() -> new IllegalArgumentException(String.format("%s value dont exist on BuyOperations",operationId)));
        buyOperation.updateOperationStatus(OperationStatus.DONE);
        buyOperation = executeBuyOperationOutputPort.updateBuyOperation(buyOperation);
        //todo:question, is necessary create a new UUID o only need a update same ID
        boolean currencyBoxUpdated = updateCurrencyMultiBox.reserveDoneCurrencyBoxAfterOfConfirmBuyOperation(buyOperation);
        //todo: the follow comments, is to separate responsibilities of each box
        //CurrencyMultiBox officeDebtResponse = manageOfficeDebt.createOfficeDebt(currencyMultiBox);
        //CurrencyMultiBox pesosBoxResponse = updateCurrencyMultiBox.updateCurrencyMultiBox(currencyMultiBox);
        //call to print PDF for client and user
        // todo  -> printOperation.printTicket();
        byte[] ticketGenerated = generateTicket.generateBuyOperationTicket(buyOperation);
        System.out.println(Arrays.toString(ticketGenerated));
        return true;
    }
}
