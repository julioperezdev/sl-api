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
        Float newQuantity = calculateOfNewQuantityToOfficeBoxByCanceledOperation(actualQuantityOfOfficeBox, buyOperation.getTotal());
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                officeBox.getCreatedAt(),
                Date.from(Instant.now()),
                officeBox.getCurrencyBox(),
                buyOperation.getId(),
                OperationType.BUY.value(),
                newQuantity,
                buyOperation.getTotal(),
                MultiBoxStatus.CANCELLED.value(),
                officeBox.getQuantityChanged());
    }
    private Float calculateOfNewQuantityToOfficeBoxByCanceledOperation(Float actualQuantityOfOfficeBox, Float buyOperationTotal){
        return actualQuantityOfOfficeBox - buyOperationTotal;
    }
}
