package dev.julioperez.littleTree.operation.shared.application.cancelOperation.service;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.returnQuantityOnCurrencyBoxByCancelledBuyOperation.ReturnQuantityOnCurrencyBoxByCancelledBuyOperation;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.returnQuantityOnCurrencyBoxByCancelledSellOperation.ReturnQuantityOnCurrencyBoxByCancelledSellOperation;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationStatus;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationType;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;
import dev.julioperez.littleTree.operation.shared.domain.port.cancelOperation.CancelOperation;
import dev.julioperez.littleTree.operation.shared.domain.port.cancelOperation.CancelOperationOutputPort;
import dev.julioperez.littleTree.operation.shared.domain.port.getOperations.GetOperations;

public class CancelOperationService implements CancelOperation {
    private final CancelOperationOutputPort cancelOperationOutputPort;
    private final GetOperations getOperations;
    private final ReturnQuantityOnCurrencyBoxByCancelledBuyOperation returnQuantityOnCurrencyBoxByCancelledBuyOperation;
    private final ReturnQuantityOnCurrencyBoxByCancelledSellOperation returnQuantityOnCurrencyBoxByCancelledSellOperation;

    public CancelOperationService(CancelOperationOutputPort cancelOperationOutputPort, GetOperations getOperations, ReturnQuantityOnCurrencyBoxByCancelledBuyOperation returnQuantityOnCurrencyBoxByCancelledBuyOperation, ReturnQuantityOnCurrencyBoxByCancelledSellOperation returnQuantityOnCurrencyBoxByCancelledSellOperation) {
        this.cancelOperationOutputPort = cancelOperationOutputPort;
        this.getOperations = getOperations;
        this.returnQuantityOnCurrencyBoxByCancelledBuyOperation = returnQuantityOnCurrencyBoxByCancelledBuyOperation;
        this.returnQuantityOnCurrencyBoxByCancelledSellOperation = returnQuantityOnCurrencyBoxByCancelledSellOperation;
    }

    @Override
    public boolean changePendingToCancelOperation(String operationId, String operationTypeValue) {
        OperationType operationType = OperationType.returnOperationTypeByDescription(operationTypeValue);
        boolean response = false;
        if(operationType.isBuyOperation()){
            BuyOperation buyOperation = getOperations.getBuyOperationById(operationId)
                    .orElseThrow(() -> new IllegalArgumentException(String.format("%s value dont exist on BuyOperations", operationId)));
            buyOperation.updateOperationStatus(OperationStatus.CANCELLED);
            BuyOperation cancelledBuyOperation = cancelOperationOutputPort.updateBuyOperation(buyOperation);
            response = returnQuantityOnCurrencyBoxByCancelledBuyOperation.execute(cancelledBuyOperation);
        } else if (operationType.isSellOperation()) {
            SellOperation sellOperation = getOperations.getSellOperationById(operationId)
                    .orElseThrow(() -> new IllegalArgumentException(String.format("%s value dont exist on SellOperations",operationId)));
            sellOperation.updateOperationStatus(OperationStatus.CANCELLED);
            SellOperation cancelledSellOperation = cancelOperationOutputPort.updateSellOperations(sellOperation);
            response = returnQuantityOnCurrencyBoxByCancelledSellOperation.execute(cancelledSellOperation);
        }
        return response;
    }
}
