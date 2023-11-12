package dev.julioperez.littleTree.box.currencyBox.officeDebt.application.manageOfficeDebt.service;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.MultiBoxStatus;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.currencyBox.officeDebt.domain.port.manageOfficeDebt.ManageOfficeDebt;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationType;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public class ManageOfficeDebtService implements ManageOfficeDebt {

    public ManageOfficeDebtService() {
    }

    @Override
    public CurrencyMultiBox recordPendingOfficeBoxToEgress(CurrencyMultiBox officeBox, BuyOperation buyOperation) {
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

    @Override
    public CurrencyMultiBox recordOfficeBoxToReturnEgress(CurrencyMultiBox officeBox, BuyOperation buyOperation, Float actualQuantityOfOfficeBox) {
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

    @Override
    public CurrencyMultiBox recordOfficeBoxToConfirmEgress(CurrencyMultiBox officeBox, BuyOperation buyOperation, Float actualQuantityOfOfficeBox) {
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
/*
    @Override
    public CurrencyMultiBox createOfficeDebt(CurrencyMultiBox newOfficeDebt) {
        CurrencyMultiBox dtoResponse = newOfficeDebt;
        //return updateCurrencyMultiBox.updateCurrencyMultiBox(dtoResponse);
        return null;
    }

    @Override
    public CurrencyMultiBox payOfficeDebt(CurrencyMultiBox officeDebt, Float quantity) {
        //falta analizar como debe construirse este registro
        //queda la duda si el valor debe aumentar o reducirse
        CurrencyMultiBox officeDebtUpdated = new CurrencyMultiBox(
                officeDebt.getId(),
                Date.from(Instant.now()),
                "",
                officeDebt.getOperationId(),
                officeDebt.reduceQuantity(quantity),
                officeDebt.getPriceOperation(),
                officeDebt.getMultiBoxStatus());
        //return updateCurrencyMultiBox.updateCurrencyMultiBox(officeDebtUpdated);
        return null;
    }*/
}
