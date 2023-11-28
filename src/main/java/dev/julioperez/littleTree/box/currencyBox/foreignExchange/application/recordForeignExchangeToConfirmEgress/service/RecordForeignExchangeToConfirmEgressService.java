package dev.julioperez.littleTree.box.currencyBox.foreignExchange.application.recordForeignExchangeToConfirmEgress.service;

import dev.julioperez.littleTree.box.currencyBox.foreignExchange.domain.port.recordForeignExchangeToConfirmEgress.RecordForeignExchangeToConfirmEgress;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.dto.LastQuantityAndQuantityViewed;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.MultiBoxStatus;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationType;

import java.sql.Date;
import java.time.Instant;
import java.util.UUID;

public class RecordForeignExchangeToConfirmEgressService implements RecordForeignExchangeToConfirmEgress {
    @Override
    public CurrencyMultiBox execute(CurrencyMultiBox foreignExchangeBox, SellOperation sellOperation, LastQuantityAndQuantityViewed actualQuantityAndQuantityViewedByForeignExchangeBox) {
    Float newQuantityViewed = actualQuantityAndQuantityViewedByForeignExchangeBox.lastQuantityViewed() - sellOperation.getQuantity();
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                foreignExchangeBox.getCreatedAt(),
                Date.from(Instant.now()),
                foreignExchangeBox.getCurrencyBox(),
                sellOperation.getId(),
                OperationType.SELL.value(),
                actualQuantityAndQuantityViewedByForeignExchangeBox.lastQuantity(),
                sellOperation.getQuantity(),
                MultiBoxStatus.DONE.value(),
                newQuantityViewed);
    }
}
