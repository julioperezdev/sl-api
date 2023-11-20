package dev.julioperez.littleTree.box.currencyBox.pesos.application.recordPendingPesosBoxToIngress.service;

import dev.julioperez.littleTree.box.currencyBox.pesos.domain.port.recordPendingPesosBoxToIngress.RecordPendingPesosBoxToIngress;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.MultiBoxStatus;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationType;

import java.sql.Date;
import java.time.Instant;
import java.util.UUID;

public class RecordPendingPesosBoxToIngressService implements RecordPendingPesosBoxToIngress {
    @Override
    public CurrencyMultiBox execute(CurrencyMultiBox pesosBox, SellOperation sellOperation) {
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                pesosBox.getCurrencyBox(),
                sellOperation.getId(),
                OperationType.SELL.value(),
                pesosBox.getQuantity(),
                sellOperation.getTotal(),
                MultiBoxStatus.PENDING.value());
    }
}
