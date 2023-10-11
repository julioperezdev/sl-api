package dev.julioperez.littleTree.operation.application.executeSellOperation.service;

import dev.julioperez.littleTree.box.domain.model.Balance;
import dev.julioperez.littleTree.box.domain.port.manageBalance.ManageBalance;
import dev.julioperez.littleTree.box.domain.port.updateCurrencyMultiBox.UpdateCurrencyMultiBox;
import dev.julioperez.littleTree.operation.domain.enums.OperationStatus;
import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperation;
import dev.julioperez.littleTree.operation.domain.port.executeSellOperation.ExecuteSellOperation;
import dev.julioperez.littleTree.operation.domain.port.executeSellOperation.ExecuteSellOperationOutputPort;
import dev.julioperez.littleTree.operation.domain.port.generateTicket.GenerateTicket;
import dev.julioperez.littleTree.operation.domain.port.getOperations.GetOperations;
import dev.julioperez.littleTree.seller.domain.dto.CreateSellerCommissionRequest;
import dev.julioperez.littleTree.seller.domain.port.createSellerCommission.CreateSellerCommission;

import java.sql.Date;
import java.time.Instant;
import java.util.Arrays;
import java.util.UUID;

public class ExecuteSellOperationService implements ExecuteSellOperation {
    private final ExecuteSellOperationOutputPort executeSellOperationOutputPort;
    private final GetOperations getOperations;
    private final UpdateCurrencyMultiBox updateCurrencyMultiBox;
    private final ManageBalance manageBalance;
    private final CreateSellerCommission createSellerCommission;
    private final GenerateTicket generateTicket;

    public ExecuteSellOperationService(ExecuteSellOperationOutputPort executeSellOperationOutputPort, GetOperations getOperations, UpdateCurrencyMultiBox updateCurrencyMultiBox, ManageBalance manageBalance, CreateSellerCommission createSellerCommission, GenerateTicket generateTicket) {
        this.executeSellOperationOutputPort = executeSellOperationOutputPort;
        this.getOperations = getOperations;
        this.updateCurrencyMultiBox = updateCurrencyMultiBox;
        this.manageBalance = manageBalance;
        this.createSellerCommission = createSellerCommission;
        this.generateTicket = generateTicket;
    }

    @Override
    public boolean executeSellOperation(String operationId, CreateSellerCommissionRequest createSellerCommissionRequest) {
        SellOperation sellOperation = getOperations.getSellOperationById(operationId)
                .orElseThrow(() -> new IllegalArgumentException(String.format("%s value dont exist on SellOperations",operationId)));
        sellOperation.updateOperationStatus(OperationStatus.DONE);
        sellOperation = executeSellOperationOutputPort.updateSellOperations(sellOperation);
        //check if used valid values
        boolean updatedCurrencyMultiBox = updateCurrencyMultiBox.reserveDoneCurrencyBoxAfterOfConfirmSellOperation(sellOperation);

        //here
        //create a balance record
        Balance balance = new Balance(UUID.randomUUID().toString(), sellOperation.getProfit(), sellOperation.getId(), Date.from(Instant.now()),Date.from(Instant.now()));
        //when save should have status with unassigned sellerBox
        manageBalance.createBalance(balance);
        //should call seller commission if required
        if(sellOperation.hasSeller()){
            createSellerCommission.createSellerCommission(createSellerCommissionRequest);
        };
        // todo  -> printOperation.printTicket();
        //byte[] ticketGenerated = generateTicket.generateSellOperationTicket(sellOperation);
        //System.out.println(Arrays.toString(ticketGenerated));
        return true;
    }
}
