package dev.julioperez.littleTree.box.currencyBox.officeDebt.application.recordPendingOfficeBoxToEgress.service;

import dev.julioperez.littleTree.box.currencyBox.officeDebt.domain.port.recordPendingOfficeBoxToEgress.RecordPendingOfficeBoxToEgress;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.MultiBoxStatus;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationType;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public class RecordPendingOfficeBoxToEgressService implements RecordPendingOfficeBoxToEgress {
    @Override
    public CurrencyMultiBox execute(CurrencyMultiBox officeBox, BuyOperation buyOperation) {
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                officeBox.getCurrencyBox(),
                buyOperation.getId(),
                OperationType.BUY.value(),
                officeBox.addQuantity(buyOperation.getTotal()),
                buyOperation.getTotal(),
                MultiBoxStatus.PENDING.value());
    }
}
