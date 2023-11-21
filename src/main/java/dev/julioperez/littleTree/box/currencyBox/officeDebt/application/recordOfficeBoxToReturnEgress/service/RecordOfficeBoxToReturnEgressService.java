package dev.julioperez.littleTree.box.currencyBox.officeDebt.application.recordOfficeBoxToReturnEgress.service;

import dev.julioperez.littleTree.box.currencyBox.officeDebt.domain.port.recordOfficeBoxToReturnEgress.RecordOfficeBoxToReturnEgress;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.MultiBoxStatus;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationType;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public class RecordOfficeBoxToReturnEgressService implements RecordOfficeBoxToReturnEgress {
    @Override
    public CurrencyMultiBox execute(CurrencyMultiBox officeBox, BuyOperation buyOperation, Float actualQuantityOfOfficeBox) {
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                officeBox.getCurrencyBox(),
                buyOperation.getId(),
                OperationType.BUY.value(),
                calculateOfNewQuantityToOfficeBoxByCanceledOperation(actualQuantityOfOfficeBox, buyOperation.getTotal()),
                buyOperation.getTotal(),
                MultiBoxStatus.CANCELLED.value());
    }
    private Float calculateOfNewQuantityToOfficeBoxByCanceledOperation(Float actualQuantityOfOfficeBox, Float buyOperationTotal){
        return actualQuantityOfOfficeBox - buyOperationTotal;
    }
}
