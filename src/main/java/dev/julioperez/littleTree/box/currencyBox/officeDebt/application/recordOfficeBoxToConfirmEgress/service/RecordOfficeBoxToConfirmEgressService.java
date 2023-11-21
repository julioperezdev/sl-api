package dev.julioperez.littleTree.box.currencyBox.officeDebt.application.recordOfficeBoxToConfirmEgress.service;

import dev.julioperez.littleTree.box.currencyBox.officeDebt.domain.port.recordOfficeBoxToConfirmEgress.RecordOfficeBoxToConfirmEgress;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.MultiBoxStatus;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationType;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public class RecordOfficeBoxToConfirmEgressService implements RecordOfficeBoxToConfirmEgress {
    @Override
    public CurrencyMultiBox execute(CurrencyMultiBox officeBox, BuyOperation buyOperation, Float actualQuantityOfOfficeBox) {
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                officeBox.getCurrencyBox(),
                buyOperation.getId(),
                OperationType.BUY.value(),
                actualQuantityOfOfficeBox,
                buyOperation.getTotal(),
                MultiBoxStatus.DONE.value());
    }
}
