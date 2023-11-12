package dev.julioperez.littleTree.box.currencyBox.officeDebt.application.payDebt.service;

import dev.julioperez.littleTree.box.currencyBox.officeDebt.domain.dto.PayDebtRequest;
import dev.julioperez.littleTree.box.currencyBox.officeDebt.domain.port.payDebt.PayDebt;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.getCurrencyMultibox.GetCurrencyMultibox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.updateCurrencyMultiBox.UpdateCurrencyMultiBox;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationStatus;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationType;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class PayDebtService implements PayDebt {

    private final GetCurrencyMultibox getCurrencyMultibox;
    private final UpdateCurrencyMultiBox updateCurrencyMultiBox;

    public PayDebtService(GetCurrencyMultibox getCurrencyMultibox, UpdateCurrencyMultiBox updateCurrencyMultiBox) {
        this.getCurrencyMultibox = getCurrencyMultibox;
        this.updateCurrencyMultiBox = updateCurrencyMultiBox;
    }

    @Override
    public boolean execute(PayDebtRequest payDebtRequest) {
        CurrencyMultiBox officeDebt = getCurrencyMultibox.getLastCurrencyMultiboxByCurrencyBox(CurrencyBox.PESO_OFFICE);
        if(Objects.nonNull(officeDebt) && !officeDebt.getQuantity().equals(payDebtRequest.debtAmount())) throw new IllegalArgumentException("Cant follow the process of pay debt because dont match values");
        CurrencyMultiBox pesosBox = getCurrencyMultibox.getLastCurrencyMultiboxByCurrencyBox(CurrencyBox.PESO);
        if(pesosBox.getQuantity() < officeDebt.getQuantity()) throw new IllegalArgumentException("Dont complete process because pesos box have less of office debt");
        CurrencyMultiBox officeDebtPayed = newOfficeDebt(officeDebt);
        CurrencyMultiBox pesosBoxPayed = newPesosBox(pesosBox, officeDebt.getQuantity());
        boolean isSuccessSaved = updateCurrencyMultiBox.updateCurrenciesMultiboxBoxes(List.of(officeDebtPayed, pesosBoxPayed));
        if(!isSuccessSaved) throw new IllegalArgumentException("dont complete");//SOS process if not is success
        return true;
    }

    private CurrencyMultiBox newOfficeDebt(CurrencyMultiBox officeDebt){
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                CurrencyBox.PESO_OFFICE.value(),
                null,
                OperationType.DEBT_PAYMENT.value(),
                0f,
                officeDebt.getQuantity(),
                OperationStatus.DONE.value());
    }

    private CurrencyMultiBox newPesosBox(CurrencyMultiBox pesosBox, Float debt) {
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                CurrencyBox.PESO.value(),
                null,
                OperationType.DEBT_PAYMENT.value(),
                pesosBox.reduceQuantity(debt),
                debt,
                OperationStatus.DONE.value());
    }
}
