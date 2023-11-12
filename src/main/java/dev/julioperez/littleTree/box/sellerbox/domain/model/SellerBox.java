package dev.julioperez.littleTree.box.sellerbox.domain.model;


import dev.julioperez.littleTree.box.sellerbox.domain.enums.SellerBoxNames;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationType;

import java.util.Date;

import static dev.julioperez.littleTree.box.sellerbox.domain.enums.SellerBoxNames.returnSellerBoxNamesByValue;

public final class SellerBox {

    private final SellerBoxId id;
    private final SellerBoxQuantity quantity;
    private final SellerBoxQuantityOperation quantityOperation;
    private final SellerBoxNames name;
    private final OperationType operationType;
    private final SellerBoxCreatedAt createdAt;
    private final SellerBoxUpdatedAt updatedAt;

    public SellerBox(String id, Float quantity,Float quantityOperation, String name, String operationType, Date createdAt, Date updatedAt) {
        this.id = new SellerBoxId(id);
        this.quantity = new SellerBoxQuantity(quantity);
        this.quantityOperation = new SellerBoxQuantityOperation(quantityOperation);
        this.name = returnSellerBoxNamesByValue(name);
        this.operationType = OperationType.returnOperationTypeByDescription(operationType);
        this.createdAt = new SellerBoxCreatedAt(createdAt);
        this.updatedAt = new SellerBoxUpdatedAt(updatedAt);
    }

    public String getId() {
        return id.value();
    }

    public Float addQuantity(Float amount){
        return this.getQuantity() + amount;
    }

    public Float reduceQuantity(Float amount){
        return this.getQuantity() - amount;
    }

    public Float getQuantity() {
        return quantity.value();
    }
    public Float getQuantityOperation() {
        return quantityOperation.value();
    }
    public String getName(){
        return name.value();
    }
    public String getOperationType(){
        return operationType.value();
    }
    public Date getCreatedAt(){
        return createdAt.value();
    }
    public Date getUpdatedAt(){
        return updatedAt.value();
    }
}
