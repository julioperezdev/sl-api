package dev.julioperez.littleTree.box.currencyBox.pesos.application.recordPesosBoxToConfirmEgress.service;

import dev.julioperez.littleTree.box.currencyBox.pesos.domain.port.recordPesosBoxToConfirmEgress.RecordPesosBoxToConfirmEgress;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.MultiBoxStatus;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationType;

import java.sql.Date;
import java.time.Instant;
import java.util.UUID;

public class RecordPesosBoxToConfirmEgressService implements RecordPesosBoxToConfirmEgress {
    @Override
    public CurrencyMultiBox execute(CurrencyMultiBox pesosBox, BuyOperation buyOperation, Float actualQuantityOfPesosBox) {
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                pesosBox.getCurrencyBox(),
                buyOperation.getId(),
                OperationType.BUY.value(),
                actualQuantityOfPesosBox,
                buyOperation.getTotal(),
                MultiBoxStatus.DONE.value());
    }
}
