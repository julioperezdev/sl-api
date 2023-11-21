package dev.julioperez.littleTree.operation.sellOperation.application.executeSellOperation.service;

import dev.julioperez.littleTree.box.balance.domain.port.createBalance.CreateBalance;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.reserveDoneCurrencyBoxAfterOfConfirmSellOperation.ReserveDoneCurrencyBoxAfterOfConfirmSellOperation;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationStatus;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.port.executeSellOperation.ExecuteSellOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.port.executeSellOperation.ExecuteSellOperationOutputPort;
import dev.julioperez.littleTree.operation.sellOperation.domain.port.generateTicket.GenerateTicket;
import dev.julioperez.littleTree.operation.shared.domain.port.getOperations.GetOperations;
import dev.julioperez.littleTree.seller.sellerCommission.domain.dto.CreateSellerCommissionRequest;
import dev.julioperez.littleTree.seller.sellerCommission.domain.port.createSellerCommission.CreateSellerCommission;

public class ExecuteSellOperationService implements ExecuteSellOperation {
    private final ExecuteSellOperationOutputPort executeSellOperationOutputPort;
    private final GetOperations getOperations;
    private final ReserveDoneCurrencyBoxAfterOfConfirmSellOperation reserveDoneCurrencyBoxAfterOfConfirmSellOperation;
    private final CreateBalance createBalance;
    private final CreateSellerCommission createSellerCommission;
    private final GenerateTicket generateTicket;

    public ExecuteSellOperationService(ExecuteSellOperationOutputPort executeSellOperationOutputPort, GetOperations getOperations, ReserveDoneCurrencyBoxAfterOfConfirmSellOperation reserveDoneCurrencyBoxAfterOfConfirmSellOperation, CreateBalance createBalance, CreateSellerCommission createSellerCommission, GenerateTicket generateTicket) {
        this.executeSellOperationOutputPort = executeSellOperationOutputPort;
        this.getOperations = getOperations;
        this.reserveDoneCurrencyBoxAfterOfConfirmSellOperation = reserveDoneCurrencyBoxAfterOfConfirmSellOperation;
        this.createBalance = createBalance;
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
        boolean updatedCurrencyMultiBox = reserveDoneCurrencyBoxAfterOfConfirmSellOperation.execute(sellOperation);

        //here
        //create a balance record


        //when save should have status with unassigned sellerBox
        createBalance.execute(sellOperation);
        //should call seller commission if required
        if(sellOperation.hasSeller()){
            //revisar el cantidad y considerar que puede haber perdidas en las ganancias
            //la otra es que se pueda agregar una columna de sellerProfit en el sellOperation
            createSellerCommission.createSellerCommission(sellOperation);
        };
        // todo  -> printOperation.printTicket();
        //byte[] ticketGenerated = generateTicket.generateSellOperationTicket(sellOperation);
        //System.out.println(Arrays.toString(ticketGenerated));
        return true;
    }
}
