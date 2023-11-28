package dev.julioperez.littleTree.box.currencyBox.shared.application.manualTransaction.service;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.updateCurrenciesMultiboxBoxes.UpdateCurrenciesMultiboxBoxes;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationType;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.dto.ManualTransactionRequest;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.getCurrencyMultibox.GetCurrencyMultibox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.manualTransaction.ManualTransaction;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationStatus;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ManualTransactionService implements ManualTransaction {

    private final GetCurrencyMultibox getCurrencyMultibox;
    private final UpdateCurrenciesMultiboxBoxes updateCurrenciesMultiboxBoxes;

    public ManualTransactionService(GetCurrencyMultibox getCurrencyMultibox, UpdateCurrenciesMultiboxBoxes updateCurrenciesMultiboxBoxes) {
        this.getCurrencyMultibox = getCurrencyMultibox;

        this.updateCurrenciesMultiboxBoxes = updateCurrenciesMultiboxBoxes;
    }

    @Override
    public boolean execute(ManualTransactionRequest manualTransactionRequest) {
        CurrencyBox currencyBox = CurrencyBox.returnCurrencyBoxByDescription(manualTransactionRequest.currencyBoxName());
        validateAvailableCurrencyBox(currencyBox);
        validateManualType(manualTransactionRequest.manualOperationType());
        CurrencyMultiBox lastCurrencyMultiboxByCurrencyBox = getCurrencyMultibox.getLastCurrencyMultiboxByCurrencyBox(currencyBox);
        Float newTotal = newTotalByManualTransaction(manualTransactionRequest, lastCurrencyMultiboxByCurrencyBox);
        Float newQuantityVisible = newQuantityVisibleByManualTransaction(manualTransactionRequest, lastCurrencyMultiboxByCurrencyBox);
        CurrencyMultiBox newCurrencyMultiBox = toNewCurrencyMultiBox(lastCurrencyMultiboxByCurrencyBox, newTotal, newQuantityVisible,  manualTransactionRequest);
        return !updateCurrenciesMultiboxBoxes.execute(List.of(newCurrencyMultiBox)).isEmpty();
    }

    private Float newTotalByManualTransaction(ManualTransactionRequest manualTransactionRequest, CurrencyMultiBox currencyMultiBox){
        return isManualIngress(manualTransactionRequest.manualOperationType())
        ? currencyMultiBox.addQuantity(manualTransactionRequest.quantity())
        : currencyMultiBox.reduceQuantity(manualTransactionRequest.quantity());
    }

    private Float newQuantityVisibleByManualTransaction(ManualTransactionRequest manualTransactionRequest, CurrencyMultiBox currencyMultiBox){
        return isManualIngress(manualTransactionRequest.manualOperationType())
                ? currencyMultiBox.addQuantityVisible(manualTransactionRequest.quantity())
                : currencyMultiBox.reduceQuantityVisible(manualTransactionRequest.quantity());
    }

    private CurrencyMultiBox toNewCurrencyMultiBox(CurrencyMultiBox currencyMultiBox, Float newTotal, Float newQuantityVisible, ManualTransactionRequest manualTransactionRequest) {
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                Date.from(Instant.now()),
                currencyMultiBox.getCurrencyBox(),
                UUID.randomUUID().toString(),
                OperationType.returnOperationTypeByDescription(manualTransactionRequest.manualOperationType()).value(),
                newTotal,
                manualTransactionRequest.quantity(),
                OperationStatus.DONE.value(),
                newQuantityVisible);
    }

    private boolean isManualIngress(String manualType){
        if(OperationType.isCashIncomeOperation(manualType)) return true;
        else if(OperationType.isCashEgressOperation(manualType)) return false;
        else throw new IllegalArgumentException("on isManualIngress dont match with valid string options");
    }

    private void validateManualType(String manualType){
        if(!OperationType.isManualOperation(manualType))
            throw new IllegalArgumentException("on validateManualType dont match with valid string options");
    }

    private void validateAvailableCurrencyBox(CurrencyBox currencyBox){
        if(!CurrencyBox.isAvailableToManualOperation(currencyBox))
            throw new IllegalArgumentException("on validateAvailableCurrencyBox dont valid currencyBox to manual operation");
    }

}
