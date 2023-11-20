package dev.julioperez.littleTree.box.currencyBox.pesos.application.recordPesosBoxToConfirmIngress.service;

import dev.julioperez.littleTree.box.currencyBox.pesos.domain.port.recordPesosBoxToConfirmIngress.RecordPesosBoxToConfirmIngress;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.MultiBoxStatus;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationType;

import java.sql.Date;
import java.time.Instant;
import java.util.UUID;

public class RecordPesosBoxToConfirmIngressService implements RecordPesosBoxToConfirmIngress {
    @Override
    public CurrencyMultiBox execute(CurrencyMultiBox pesosBox, SellOperation sellOperation) {
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                pesosBox.getCurrencyBox(),
                sellOperation.getId(),
                OperationType.SELL.value(),
                //pesosBox.getQuantity(),
                pesosBox.addQuantity(sellOperation.getTotal()),
                sellOperation.getTotal(),
                MultiBoxStatus.DONE.value());
    }
}
