package dev.julioperez.littleTree.box.currencyBox.foreignExchange.application.recordPendingForeignExchangeToEgress.service;

import dev.julioperez.littleTree.box.currencyBox.foreignExchange.domain.port.recordPendingForeignExchangeToEgress.RecordPendingForeignExchangeToEgress;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.MultiBoxStatus;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationType;

import java.sql.Date;
import java.time.Instant;
import java.util.UUID;

public class RecordPendingForeignExchangeToEgressService implements RecordPendingForeignExchangeToEgress {
    @Override
    public CurrencyMultiBox execute(CurrencyMultiBox foreignExchangeBox, SellOperation sellOperation) {
        Float newQuantity = foreignExchangeBox.reduceQuantity(sellOperation.getQuantity());
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                Date.from(Instant.now()),
                foreignExchangeBox.getCurrencyBox(),
                sellOperation.getId(),
                OperationType.SELL.value(),
                newQuantity,
                sellOperation.getQuantity(),
                MultiBoxStatus.PENDING.value(),
                foreignExchangeBox.getQuantityChanged());
    }
}
