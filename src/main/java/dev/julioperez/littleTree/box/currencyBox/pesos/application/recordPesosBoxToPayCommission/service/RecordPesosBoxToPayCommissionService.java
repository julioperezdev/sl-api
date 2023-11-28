package dev.julioperez.littleTree.box.currencyBox.pesos.application.recordPesosBoxToPayCommission.service;

import dev.julioperez.littleTree.box.currencyBox.pesos.domain.port.recordPesosBoxToPayCommission.RecordPesosBoxToPayCommission;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.MultiBoxStatus;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationType;

import java.sql.Date;
import java.time.Instant;
import java.util.UUID;

public class RecordPesosBoxToPayCommissionService implements RecordPesosBoxToPayCommission {
    @Override
    public CurrencyMultiBox execute(CurrencyMultiBox pesosBox, Float sellerCommissionQuantity) {
        Float newQuantity = pesosBox.reduceQuantity(sellerCommissionQuantity);
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                Date.from(Instant.now()),
                pesosBox.getCurrencyBox(),
                null,
                OperationType.COMMISSION_PAYMENT.value(),
                newQuantity,
                sellerCommissionQuantity,
                MultiBoxStatus.DONE.value(),
                newQuantity);
    }
}
