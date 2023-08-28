package dev.julioperez.littleTree.box.application.manageForeignExchange.service;

import dev.julioperez.littleTree.box.domain.enums.MultiBoxStatus;
import dev.julioperez.littleTree.box.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.domain.port.manageForeignExchange.ManageForeignExchange;
import dev.julioperez.littleTree.operation.domain.model.buyOperation.BuyOperation;
import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperation;

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
                //todo:does not add foreignExchange because does not have a confirmation of operation, then should be added, buy not now
                foreignExchangeBox.getQuantity(),//todo:.addQuantity(buyOperation.getQuantity()),
                buyOperation.getPrice(),
                MultiBoxStatus.PENDING.value());
    }

    @Override
    public CurrencyMultiBox recordPendingForeignExchangeToEgress(CurrencyMultiBox foreignExchangeBox, SellOperation sellOperation) {
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                foreignExchangeBox.getCurrencyBox(),
                sellOperation.getId(),
                //todo:OLD COMMENT, does not add foreignExchange because does not have a confirmation of operation, then should be added, buy not now
                //foreignExchangeBox.getQuantity(),//todo:.addQuantity(buyOperation.getQuantity()),
                //todo 27 Aug comment, should reserve foreign exchange on sell operation
                foreignExchangeBox.reduceQuantity(sellOperation.getQuantity()),
                sellOperation.getPrice(),
                MultiBoxStatus.PENDING.value());
    }

    @Override
    public CurrencyMultiBox recordForeignExchangeBoxToReturnEgress(CurrencyMultiBox foreignExchangeBox, SellOperation sellOperation) {
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                foreignExchangeBox.getCurrencyBox(),
                sellOperation.getId(),
                foreignExchangeBox.addQuantity(sellOperation.getQuantity()),
                sellOperation.getPrice(),
                MultiBoxStatus.CANCELLED.value());
    }

    @Override
    public CurrencyMultiBox recordForeignExchangeToConfirmIngress(CurrencyMultiBox foreignExchangeBox, BuyOperation buyOperation, Float actualQuantityByForeignExchangeBox) {
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                foreignExchangeBox.getCurrencyBox(),
                buyOperation.getId(),
                calculateOfNewQuantityToForeignExchangeByConfirmOperation(actualQuantityByForeignExchangeBox, buyOperation.getQuantity()),
                buyOperation.getPrice(),
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
                foreignExchangeBox.reduceQuantity(sellOperation.getQuantity()),
                sellOperation.getPrice(),
                MultiBoxStatus.DONE.value());
    }
}
