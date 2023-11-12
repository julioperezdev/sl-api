package dev.julioperez.littleTree.box.currencyBox.foreignExchange.application.manageForeignExchange.service;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.MultiBoxStatus;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.currencyBox.foreignExchange.domain.port.manageForeignExchange.ManageForeignExchange;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationType;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;

import java.sql.Date;
import java.time.Instant;
import java.util.UUID;

public class ManageForeignExchangeService implements ManageForeignExchange {

    public ManageForeignExchangeService() {
    }

    @Override
    public CurrencyMultiBox recordPendingForeignExchangeToIngress(CurrencyMultiBox foreignExchangeBox, BuyOperation buyOperation) {
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                foreignExchangeBox.getCurrencyBox(),
                buyOperation.getId(),
                OperationType.BUY.value(),
                //todo:does not add foreignExchange because does not have a confirmation of operation, then should be added, buy not now
                foreignExchangeBox.getQuantity(),//todo:.addQuantity(buyOperation.getQuantity()),
                buyOperation.getQuantity(),
                MultiBoxStatus.PENDING.value());
    }

    @Override
    public CurrencyMultiBox recordPendingForeignExchangeToEgress(CurrencyMultiBox foreignExchangeBox, SellOperation sellOperation) {
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                foreignExchangeBox.getCurrencyBox(),
                sellOperation.getId(),
                OperationType.SELL.value(),
                //todo:OLD COMMENT, does not add foreignExchange because does not have a confirmation of operation, then should be added, buy not now
                //foreignExchangeBox.getQuantity(),//todo:.addQuantity(buyOperation.getQuantity()),
                //todo 27 Aug comment, should reserve foreign exchange on sell operation
                foreignExchangeBox.reduceQuantity(sellOperation.getQuantity()),
                sellOperation.getQuantity(),
                MultiBoxStatus.PENDING.value());
    }

    @Override
    public CurrencyMultiBox recordForeignExchangeBoxToReturnEgress(CurrencyMultiBox foreignExchangeBox, SellOperation sellOperation, Float actualQuantityByExchangeCurrencyBox) {
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                foreignExchangeBox.getCurrencyBox(),
                sellOperation.getId(),
                OperationType.SELL.value(),
                calculateOfNewQuantityToForeignExchangeBoxByCanceledOperation(actualQuantityByExchangeCurrencyBox, sellOperation.getQuantity()),//foreignExchangeBox.addQuantity(sellOperation.getQuantity()),
                sellOperation.getQuantity(),
                MultiBoxStatus.CANCELLED.value());
    }

    private Float calculateOfNewQuantityToForeignExchangeBoxByCanceledOperation(Float actualQuantityOfForeignExchangeBox, Float sellOperationTotal){
        return actualQuantityOfForeignExchangeBox + sellOperationTotal;
    }

    @Override
    public CurrencyMultiBox recordForeignExchangeToConfirmIngress(CurrencyMultiBox foreignExchangeBox, BuyOperation buyOperation, Float actualQuantityByForeignExchangeBox) {
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                foreignExchangeBox.getCurrencyBox(),
                buyOperation.getId(),
                OperationType.BUY.value(),
                calculateOfNewQuantityToForeignExchangeByConfirmOperation(actualQuantityByForeignExchangeBox, buyOperation.getQuantity()),
                buyOperation.getQuantity(),
                MultiBoxStatus.DONE.value());
    }
    private Float calculateOfNewQuantityToForeignExchangeByConfirmOperation(Float actualQuantityByForeignExchangeBox, Float buyOperationQuantity){
        return actualQuantityByForeignExchangeBox + buyOperationQuantity;
    }

    @Override
    public CurrencyMultiBox recordForeignExchangeToConfirmEgress(CurrencyMultiBox foreignExchangeBox, SellOperation sellOperation) {
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                foreignExchangeBox.getCurrencyBox(),
                sellOperation.getId(),
                OperationType.SELL.value(),
                foreignExchangeBox.reduceQuantity(sellOperation.getQuantity()),
                sellOperation.getQuantity(),
                MultiBoxStatus.DONE.value());
    }
}
