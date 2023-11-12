package dev.julioperez.littleTree.box.currencyBox.pesos.application.managePesos.service;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.MultiBoxStatus;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.currencyBox.pesos.domain.port.managePesos.ManagePesos;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationType;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;

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
                OperationType.BUY.value(),
                pesosBox.reduceQuantity(buyOperation.getTotal()),
                buyOperation.getTotal(),
                MultiBoxStatus.PENDING.value());
    }

    @Override
    public CurrencyMultiBox recordPendingPesosBoxToIngress(CurrencyMultiBox pesosBox, SellOperation sellOperation) {
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                pesosBox.getCurrencyBox(),
                sellOperation.getId(),
                OperationType.SELL.value(),
                pesosBox.getQuantity(),
                sellOperation.getTotal(),
                MultiBoxStatus.PENDING.value());
    }

    @Override
    public CurrencyMultiBox recordPesosBoxToReturnEgress(CurrencyMultiBox pesosBox, BuyOperation buyOperation, Float actualQuantityOfPesosBox) {
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                pesosBox.getCurrencyBox(),
                buyOperation.getId(),
                OperationType.BUY.value(),
                calculateOfNewQuantityToPesosBoxByCanceledOperation(actualQuantityOfPesosBox, buyOperation.getTotal()),
                buyOperation.getTotal(),
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
                OperationType.BUY.value(),
                actualQuantityOfPesosBox,
                buyOperation.getTotal(),
                MultiBoxStatus.DONE.value());
    }

    @Override
    public CurrencyMultiBox recordPesosBoxToConfirmIngress(CurrencyMultiBox pesosBox, SellOperation sellOperation) {
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                pesosBox.getCurrencyBox(),
                sellOperation.getId(),
                OperationType.SELL.value(),
                pesosBox.getQuantity(),
                sellOperation.getTotal(),
                MultiBoxStatus.DONE.value());
    }

    @Override
    public CurrencyMultiBox recordPesosBoxToPayCommission(CurrencyMultiBox pesosBox, Float sellerCommissionQuantity) {
        return new CurrencyMultiBox(
                UUID.randomUUID().toString(),
                Date.from(Instant.now()),
                pesosBox.getCurrencyBox(),
                null,
                OperationType.COMMISSION_PAYMENT.value(),
                pesosBox.reduceQuantity(sellerCommissionQuantity),
                sellerCommissionQuantity,
                MultiBoxStatus.DONE.value());
    }
}
