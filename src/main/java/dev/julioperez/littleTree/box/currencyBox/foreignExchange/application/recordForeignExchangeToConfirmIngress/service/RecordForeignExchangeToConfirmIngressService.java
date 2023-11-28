package dev.julioperez.littleTree.box.currencyBox.foreignExchange.application.recordForeignExchangeToConfirmIngress.service;

import dev.julioperez.littleTree.box.currencyBox.foreignExchange.domain.port.recordForeignExchangeToConfirmIngress.RecordForeignExchangeToConfirmIngress;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.dto.LastQuantityAndQuantityViewed;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.MultiBoxStatus;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationType;

import java.sql.Date;
import java.time.Instant;
import java.util.UUID;

public class RecordForeignExchangeToConfirmIngressService implements RecordForeignExchangeToConfirmIngress {
    @Override
    public CurrencyMultiBox execute(CurrencyMultiBox foreignExchangeBox, BuyOperation buyOperation, LastQuantityAndQuantityViewed actualQuantityAndQuantityViewedByForeignExchangeBox) {
        Float newQuantity = calculateOfNewQuantityToForeignExchangeByConfirmOperation(actualQuantityAndQuantityViewedByForeignExchangeBox.lastQuantity(), buyOperation.getQuantity());
        Float newQuantityViewed = actualQuantityAndQuantityViewedByForeignExchangeBox.lastQuantityViewed() + buyOperation.getQuantity();
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                foreignExchangeBox.getCreatedAt(),
                Date.from(Instant.now()),
                foreignExchangeBox.getCurrencyBox(),
                buyOperation.getId(),
                OperationType.BUY.value(),
                newQuantity,
                buyOperation.getQuantity(),
                MultiBoxStatus.DONE.value(),
                newQuantityViewed);
    }

    private Float calculateOfNewQuantityToForeignExchangeByConfirmOperation(Float actualQuantityByForeignExchangeBox, Float buyOperationQuantity){
        return actualQuantityByForeignExchangeBox + buyOperationQuantity;
    }
}
