package dev.julioperez.littleTree.box.domain.model;

import dev.julioperez.littleTree.box.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.box.domain.enums.MultiBoxStatus;
import dev.julioperez.littleTree.operation.domain.model.OperationId;

public final class CurrencyMultiBox {


    private final CurrencyMultiBoxId id;
    private final CurrencyMultiBoxCreatedAt createdAt;
    private final CurrencyMultiBoxUpdatedAt updatedAt;
    private final CurrencyBox currencyBox;
    private final OperationId operationId;
    private final CurrencyMultiBoxQuantity quantity;
    private final CurrencyMultiBoxPriceOperation priceOperation;
    private final MultiBoxStatus multiBoxStatus;

    public CurrencyMultiBox(CurrencyMultiBoxId id, CurrencyMultiBoxCreatedAt createdAt, CurrencyMultiBoxUpdatedAt updatedAt, CurrencyBox currencyBox, OperationId operationId, CurrencyMultiBoxQuantity quantity, CurrencyMultiBoxPriceOperation priceOperation, MultiBoxStatus multiBoxStatus) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.currencyBox = currencyBox;
        this.operationId = operationId;
        this.quantity = quantity;
        this.priceOperation = priceOperation;
        this.multiBoxStatus = multiBoxStatus;
    }
}
