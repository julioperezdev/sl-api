package dev.julioperez.littleTree.box.application.managePesos.service;

import dev.julioperez.littleTree.box.domain.enums.MultiBoxStatus;
import dev.julioperez.littleTree.box.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.domain.port.managePesos.ManagePesos;
import dev.julioperez.littleTree.operation.domain.model.buyOperation.BuyOperation;
import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperation;

import java.sql.Date;
import java.time.Instant;
import java.util.UUID;

public class ManagePesosService implements ManagePesos {

    @Override
    public CurrencyMultiBox recordPendingPesosBoxToEgress(CurrencyMultiBox pesosBox, BuyOperation buyOperation) {
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                pesosBox.getCurrencyBox(),
                buyOperation.getId(),
                pesosBox.reduceQuantity(buyOperation.getTotal()),
                buyOperation.getPrice(),
                MultiBoxStatus.PENDING.value());
    }

    @Override
    public CurrencyMultiBox recordPendingPesosBoxToIngress(CurrencyMultiBox pesosBox, SellOperation sellOperation) {
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                pesosBox.getCurrencyBox(),
                sellOperation.getId(),
                pesosBox.getQuantity(),
                sellOperation.getPrice(),
                MultiBoxStatus.PENDING.value());
    }

    @Override
    public CurrencyMultiBox recordPesosBoxToReturnEgress(CurrencyMultiBox pesosBox, BuyOperation buyOperation, Float actualQuantityOfPesosBox) {
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                pesosBox.getCurrencyBox(),
                buyOperation.getId(),
                calculateOfNewQuantityToPesosBoxByCanceledOperation(actualQuantityOfPesosBox, buyOperation.getTotal()),
                buyOperation.getPrice(),
                MultiBoxStatus.CANCELLED.value());
    }
    private Float calculateOfNewQuantityToPesosBoxByCanceledOperation(Float actualQuantityOfPesosBox, Float buyOperationTotal){
        return actualQuantityOfPesosBox + buyOperationTotal;
    }

    @Override
    public CurrencyMultiBox recordPesosBoxToConfirmEgress(CurrencyMultiBox pesosBox, BuyOperation buyOperation, Float actualQuantityOfPesosBox) {
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                pesosBox.getCurrencyBox(),
                buyOperation.getId(),
                actualQuantityOfPesosBox,
                buyOperation.getPrice(),
                MultiBoxStatus.DONE.value());
    }

    @Override
    public CurrencyMultiBox recordPesosBoxToConfirmIngress(CurrencyMultiBox pesosBox, SellOperation sellOperation) {
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                pesosBox.getCurrencyBox(),
                sellOperation.getId(),
                pesosBox.getQuantity(),
                sellOperation.getPrice(),
                MultiBoxStatus.DONE.value());
    }
}
