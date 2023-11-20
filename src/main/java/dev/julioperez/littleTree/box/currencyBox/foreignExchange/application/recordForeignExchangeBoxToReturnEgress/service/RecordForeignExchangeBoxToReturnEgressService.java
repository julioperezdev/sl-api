package dev.julioperez.littleTree.box.currencyBox.foreignExchange.application.recordForeignExchangeBoxToReturnEgress.service;

import dev.julioperez.littleTree.box.currencyBox.foreignExchange.domain.port.recordForeignExchangeBoxToReturnEgress.RecordForeignExchangeBoxToReturnEgress;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.MultiBoxStatus;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationType;

import java.sql.Date;
import java.time.Instant;
import java.util.UUID;

public class RecordForeignExchangeBoxToReturnEgressService implements RecordForeignExchangeBoxToReturnEgress {
    @Override
    public CurrencyMultiBox execute(CurrencyMultiBox foreignExchangeBox, SellOperation sellOperation, Float actualQuantityByExchangeCurrencyBox) {
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                foreignExchangeBox.getCurrencyBox(),
                sellOperation.getId(),
                OperationType.SELL.value(),
                calculateOfNewQuantityToForeignExchangeBoxByCanceledOperation(actualQuantityByExchangeCurrencyBox, sellOperation.getQuantity()),//foreignExchangeBox.addQuantity(sellOperation.getQuantity()),
                sellOperation.getQuantity(),
                MultiBoxStatus.CANCELLED.value());
    }

    private Float calculateOfNewQuantityToForeignExchangeBoxByCanceledOperation(Float actualQuantityOfForeignExchangeBox, Float sellOperationTotal){
        return actualQuantityOfForeignExchangeBox + sellOperationTotal;
    }
}
