package dev.julioperez.littleTree.box.currencyBox.officeDebt.application.recordOfficeBoxToConfirmEgress.service;

import dev.julioperez.littleTree.box.currencyBox.officeDebt.domain.port.recordOfficeBoxToConfirmEgress.RecordOfficeBoxToConfirmEgress;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.dto.LastQuantityAndQuantityViewed;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.MultiBoxStatus;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationType;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public class RecordOfficeBoxToConfirmEgressService implements RecordOfficeBoxToConfirmEgress {
    @Override
    public CurrencyMultiBox execute(CurrencyMultiBox officeBox, BuyOperation buyOperation, LastQuantityAndQuantityViewed actualQuantityAndQuantityViewedByPesosOrOfficeBox) {
        Float newQuantityViewed = actualQuantityAndQuantityViewedByPesosOrOfficeBox.lastQuantityViewed() + buyOperation.getTotal();
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                officeBox.getCreatedAt(),
                Date.from(Instant.now()),
                officeBox.getCurrencyBox(),
                buyOperation.getId(),
                OperationType.BUY.value(),
                actualQuantityAndQuantityViewedByPesosOrOfficeBox.lastQuantity(),
                buyOperation.getTotal(),
                MultiBoxStatus.DONE.value(),
                newQuantityViewed);
    }
}
