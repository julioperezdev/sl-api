package dev.julioperez.littleTree.box.currencyBox.foreignExchange.application.recordPendingForeignExchangeToIngress.service;

import dev.julioperez.littleTree.box.currencyBox.foreignExchange.domain.port.recordPendingForeignExchangeToIngress.RecordPendingForeignExchangeToIngress;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.MultiBoxStatus;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationType;

import java.sql.Date;
import java.time.Instant;
import java.util.UUID;

public class RecordPendingForeignExchangeToIngressService implements RecordPendingForeignExchangeToIngress {
    @Override
    public CurrencyMultiBox execute(CurrencyMultiBox foreignExchangeBox, BuyOperation buyOperation) {
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                foreignExchangeBox.getCurrencyBox(),
                buyOperation.getId(),
                OperationType.BUY.value(),
                //todo:does not add foreignExchange because does not have a confirmation of operation, then should be added, buy not now
                foreignExchangeBox.getQuantity(),//todo:.addQuantity(buyOperation.getQuantity()),
                buyOperation.getQuantity(),
                MultiBoxStatus.PENDING.value());
    }
}
