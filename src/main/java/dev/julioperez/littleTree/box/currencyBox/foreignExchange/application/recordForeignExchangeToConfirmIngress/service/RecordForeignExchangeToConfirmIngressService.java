package dev.julioperez.littleTree.box.currencyBox.foreignExchange.application.recordForeignExchangeToConfirmIngress.service;

import dev.julioperez.littleTree.box.currencyBox.foreignExchange.domain.port.recordForeignExchangeToConfirmIngress.RecordForeignExchangeToConfirmIngress;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.MultiBoxStatus;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationType;

import java.sql.Date;
import java.time.Instant;
import java.util.UUID;

public class RecordForeignExchangeToConfirmIngressService implements RecordForeignExchangeToConfirmIngress {
    @Override
    public CurrencyMultiBox execute(CurrencyMultiBox foreignExchangeBox, BuyOperation buyOperation, Float actualQuantityByForeignExchangeBox) {
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                foreignExchangeBox.getCurrencyBox(),
                buyOperation.getId(),
                OperationType.BUY.value(),
                calculateOfNewQuantityToForeignExchangeByConfirmOperation(actualQuantityByForeignExchangeBox, buyOperation.getQuantity()),
                buyOperation.getQuantity(),
                MultiBoxStatus.DONE.value());
    }

    private Float calculateOfNewQuantityToForeignExchangeByConfirmOperation(Float actualQuantityByForeignExchangeBox, Float buyOperationQuantity){
        return actualQuantityByForeignExchangeBox + buyOperationQuantity;
    }
}
