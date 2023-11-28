package dev.julioperez.littleTree.box.currencyBox.shared.domain.model;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.MultiBoxStatus;

import java.util.Date;

public final class CurrencyMultiBox {


    private final CurrencyMultiBoxId id;
    private final CurrencyMultiBoxCreatedAt createdAt;
    private final CurrencyMultiBoxUpdatedAt updatedAt;
    private final CurrencyBox currencyBox;
    private final CurrencyMultiBoxOperationId operationId;
    private final CurrencyMultiBoxOperationType operationType;
    private final CurrencyMultiBoxQuantity quantity;
    private final CurrencyMultiBoxQuantityOperation quantityOperation;
    private final MultiBoxStatus multiBoxStatus;
    private final CurrencyMultiboxQuantityChanged quantityChanged;

    public CurrencyMultiBox(String id, Date createdAt, Date updatedAt, String currencyBox, String operationId,String operationType, Float quantity, Float quantityOperation, String multiBoxStatus, Float quantityChanged) {
        this.id = new CurrencyMultiBoxId(id);
        this.createdAt = new CurrencyMultiBoxCreatedAt(createdAt);
        this.updatedAt = new CurrencyMultiBoxUpdatedAt(updatedAt);
        this.currencyBox = CurrencyBox.returnCurrencyBoxByDescription(currencyBox);
        this.operationId = new CurrencyMultiBoxOperationId(operationId);
        this.operationType = new CurrencyMultiBoxOperationType(operationType);
        this.quantity = new CurrencyMultiBoxQuantity(quantity);
        this.quantityOperation = new CurrencyMultiBoxQuantityOperation(quantityOperation);
        this.multiBoxStatus = MultiBoxStatus.returnMultiBoxStatusByDescription(multiBoxStatus);
        this.quantityChanged =  new CurrencyMultiboxQuantityChanged(quantityChanged);
    }

    public Float addQuantity(Float amount){
        return this.getQuantity() + amount;
    }

    public Float reduceQuantity(Float amount){
        return this.getQuantity() - amount;
    }

    public Float addQuantityVisible(Float amount){
        return this.getQuantityChanged() + amount;
    }

    public Float reduceQuantityVisible(Float amount){
        return this.getQuantityChanged() - amount;
    }

    public String getId() {
        return id.value();
    }

    public Date getCreatedAt(){
        return createdAt.value();
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

    public String getOperationType(){
        return operationType.value();
    }

    public Float getQuantity() {
        return quantity.value();
    }

    public Float getQuantityOperation() {
        return quantityOperation.value();
    }

    public String getMultiBoxStatus() {
        return multiBoxStatus.value();
    }

    public Float getQuantityChanged(){
            return quantityChanged.value();
    }
}
