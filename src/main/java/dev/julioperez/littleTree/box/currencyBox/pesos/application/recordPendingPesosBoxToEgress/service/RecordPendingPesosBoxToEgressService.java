package dev.julioperez.littleTree.box.currencyBox.pesos.application.recordPendingPesosBoxToEgress.service;

import dev.julioperez.littleTree.box.currencyBox.pesos.domain.port.recordPendingPesosBoxToEgress.RecordPendingPesosBoxToEgress;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.MultiBoxStatus;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationType;

import java.sql.Date;
import java.time.Instant;
import java.util.UUID;

public class RecordPendingPesosBoxToEgressService implements RecordPendingPesosBoxToEgress {
    @Override
    public CurrencyMultiBox execute(CurrencyMultiBox pesosBox, BuyOperation buyOperation) {
        Float newQuantity = pesosBox.reduceQuantity(buyOperation.getTotal());
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                Date.from(Instant.now()),
                pesosBox.getCurrencyBox(),
                buyOperation.getId(),
                OperationType.BUY.value(),
                newQuantity,
                buyOperation.getTotal(),
                MultiBoxStatus.PENDING.value(),
                pesosBox.getQuantityChanged());
    }
}
