package dev.julioperez.littleTree.operation.application.cancelOperation.service;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.updateCurrencyMultiBox.UpdateCurrencyMultiBox;
import dev.julioperez.littleTree.operation.domain.enums.OperationStatus;
import dev.julioperez.littleTree.operation.domain.enums.OperationType;
import dev.julioperez.littleTree.operation.domain.model.buyOperation.BuyOperation;
import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperation;
import dev.julioperez.littleTree.operation.domain.port.cancelOperation.CancelOperation;
import dev.julioperez.littleTree.operation.domain.port.cancelOperation.CancelOperationOutputPort;
import dev.julioperez.littleTree.operation.domain.port.getOperations.GetOperations;

public class CancelOperationService implements CancelOperation {
    private final CancelOperationOutputPort cancelOperationOutputPort;
    private final GetOperations getOperations;
    private final UpdateCurrencyMultiBox updateCurrencyMultiBox;

    public CancelOperationService(CancelOperationOutputPort cancelOperationOutputPort, GetOperations getOperations, UpdateCurrencyMultiBox updateCurrencyMultiBox) {
        this.cancelOperationOutputPort = cancelOperationOutputPort;
        this.getOperations = getOperations;
        this.updateCurrencyMultiBox = updateCurrencyMultiBox;
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
            response = updateCurrencyMultiBox.returnQuantityOnCurrencyBoxByCancelledBuyOperation(cancelledBuyOperation);
        } else if (operationType.isSellOperation()) {
            SellOperation sellOperation = getOperations.getSellOperationById(operationId)
                    .orElseThrow(() -> new IllegalArgumentException(String.format("%s value dont exist on SellOperations",operationId)));
            sellOperation.updateOperationStatus(OperationStatus.CANCELLED);
            SellOperation cancelledSellOperation = cancelOperationOutputPort.updateSellOperations(sellOperation);
            response = updateCurrencyMultiBox.returnQuantityOnCurrencyBoxByCancelledSellOperation(cancelledSellOperation);
        }
        return response;
    }
}
