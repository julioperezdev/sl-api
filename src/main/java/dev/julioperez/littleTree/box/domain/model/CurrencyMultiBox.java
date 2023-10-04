package dev.julioperez.littleTree.box.domain.model;

import dev.julioperez.littleTree.box.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.box.domain.enums.MultiBoxStatus;
import dev.julioperez.littleTree.seller.domain.model.CurrencyMultiBoxOperationId;

import java.util.Date;

public final class CurrencyMultiBox {


    private final CurrencyMultiBoxId id;
    private final CurrencyMultiBoxUpdatedAt updatedAt;
    private final CurrencyBox currencyBox;
    private final CurrencyMultiBoxOperationId operationId;
    private final CurrencyMultiBoxQuantity quantity;
    private final CurrencyMultiBoxPriceOperation priceOperation;
    private final MultiBoxStatus multiBoxStatus;

    public CurrencyMultiBox(String id, Date updatedAt, String currencyBox, String operationId, Float quantity, Float priceOperation, String multiBoxStatus) {
        this.id = new CurrencyMultiBoxId(id);
        this.updatedAt = new CurrencyMultiBoxUpdatedAt(updatedAt);
        this.currencyBox = CurrencyBox.returnCurrencyBoxByDescription(currencyBox);
        this.operationId = new CurrencyMultiBoxOperationId(operationId);
        this.quantity = new CurrencyMultiBoxQuantity(quantity);
        this.priceOperation = new CurrencyMultiBoxPriceOperation(priceOperation);
        this.multiBoxStatus = MultiBoxStatus.returnMultiBoxStatusByDescription(multiBoxStatus);
    }

    public Float addQuantity(Float amount){
        return this.getQuantity() + amount;
    }

    public Float reduceQuantity(Float amount){
        return this.getQuantity() - amount;
    }

    public String getId() {
        return id.value();
    }

    public Date getUpdatedAt() {
        return updatedAt.value();
    }

    public String getCurrencyBox() {
        return currencyBox.value();
    }

    public String getOperationId() {
        return operationId.value();
    }

    public Float getQuantity() {
        return quantity.value();
    }

    public Float getPriceOperation() {
        return priceOperation.value();
    }

    public String getMultiBoxStatus() {
        return multiBoxStatus.value();
    }
}
