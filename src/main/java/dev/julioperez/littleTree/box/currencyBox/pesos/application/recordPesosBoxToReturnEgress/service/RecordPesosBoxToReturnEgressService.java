package dev.julioperez.littleTree.box.currencyBox.pesos.application.recordPesosBoxToReturnEgress.service;

import dev.julioperez.littleTree.box.currencyBox.pesos.domain.port.recordPesosBoxToReturnEgress.RecordPesosBoxToReturnEgress;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.MultiBoxStatus;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationType;

import java.sql.Date;
import java.time.Instant;
import java.util.UUID;

public class RecordPesosBoxToReturnEgressService implements RecordPesosBoxToReturnEgress {
    @Override
    public CurrencyMultiBox execute(CurrencyMultiBox pesosBox, BuyOperation buyOperation, Float actualQuantityOfPesosBox) {
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                pesosBox.getCurrencyBox(),
                buyOperation.getId(),
                OperationType.BUY.value(),
                calculateOfNewQuantityToPesosBoxByCanceledOperation(actualQuantityOfPesosBox, buyOperation.getTotal()),
                buyOperation.getTotal(),
                MultiBoxStatus.CANCELLED.value());
    }
    private Float calculateOfNewQuantityToPesosBoxByCanceledOperation(Float actualQuantityOfPesosBox, Float buyOperationTotal){
        return actualQuantityOfPesosBox + buyOperationTotal;
    }
}
