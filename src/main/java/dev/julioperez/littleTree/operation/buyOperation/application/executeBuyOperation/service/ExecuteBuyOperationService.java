package dev.julioperez.littleTree.operation.buyOperation.application.executeBuyOperation.service;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.reserveDoneCurrencyBoxAfterOfConfirmBuyOperation.ReserveDoneCurrencyBoxAfterOfConfirmBuyOperation;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationStatus;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.buyOperation.domain.port.executeBuyOperation.ExecuteBuyOperation;
import dev.julioperez.littleTree.operation.buyOperation.domain.port.executeBuyOperation.ExecuteBuyOperationOutputPort;
import dev.julioperez.littleTree.operation.sellOperation.domain.port.generateTicket.GenerateTicket;
import dev.julioperez.littleTree.operation.shared.domain.port.getOperations.GetOperations;

public class ExecuteBuyOperationService implements ExecuteBuyOperation {
    private final ExecuteBuyOperationOutputPort executeBuyOperationOutputPort;
    private final GetOperations getOperations;
    private final ReserveDoneCurrencyBoxAfterOfConfirmBuyOperation reserveDoneCurrencyBoxAfterOfConfirmBuyOperation;
    private final GenerateTicket generateTicket;

    public ExecuteBuyOperationService(ExecuteBuyOperationOutputPort executeBuyOperationOutputPort, GetOperations getOperations, ReserveDoneCurrencyBoxAfterOfConfirmBuyOperation reserveDoneCurrencyBoxAfterOfConfirmBuyOperation, GenerateTicket generateTicket) {
        this.executeBuyOperationOutputPort = executeBuyOperationOutputPort;
        this.getOperations = getOperations;
        this.reserveDoneCurrencyBoxAfterOfConfirmBuyOperation = reserveDoneCurrencyBoxAfterOfConfirmBuyOperation;
        this.generateTicket = generateTicket;
    }

    @Override
    public boolean executeBuyOperation(String operationId) {
        BuyOperation buyOperation = getOperations.getBuyOperationById(operationId)
                .orElseThrow(() -> new IllegalArgumentException(String.format("%s value dont exist on BuyOperations",operationId)));
        buyOperation.updateOperationStatus(OperationStatus.DONE);
        buyOperation = executeBuyOperationOutputPort.updateBuyOperation(buyOperation);
        //todo:question, is necessary create a new UUID o only need a update same ID
        boolean currencyBoxUpdated = reserveDoneCurrencyBoxAfterOfConfirmBuyOperation.execute(buyOperation);
        //todo: the follow comments, is to separate responsibilities of each box
        //CurrencyMultiBox officeDebtResponse = manageOfficeDebt.createOfficeDebt(currencyMultiBox);
        //CurrencyMultiBox pesosBoxResponse = updateCurrencyMultiBox.updateCurrencyMultiBox(currencyMultiBox);
        //call to print PDF for client and user
        // todo  -> printOperation.printTicket();
        //byte[] ticketGenerated = generateTicket.generateBuyOperationTicket(buyOperation);
        //System.out.println(Arrays.toString(ticketGenerated));
        return true;
    }
}
