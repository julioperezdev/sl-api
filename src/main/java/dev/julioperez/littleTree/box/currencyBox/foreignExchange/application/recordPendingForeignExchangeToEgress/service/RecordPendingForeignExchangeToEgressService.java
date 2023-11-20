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
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                foreignExchangeBox.getCurrencyBox(),
                sellOperation.getId(),
                OperationType.SELL.value(),
                //todo:OLD COMMENT, does not add foreignExchange because does not have a confirmation of operation, then should be added, buy not now
                //foreignExchangeBox.getQuantity(),//todo:.addQuantity(buyOperation.getQuantity()),
                //todo 27 Aug comment, should reserve foreign exchange on sell operation
                foreignExchangeBox.reduceQuantity(sellOperation.getQuantity()),
                sellOperation.getQuantity(),
                MultiBoxStatus.PENDING.value());
    }
}
