package dev.julioperez.littleTree.box.domain.model;


import dev.julioperez.littleTree.operation.domain.enums.OperationType;

import java.util.Date;

public final class Balance {

    private final BalanceId id;
    private final BalanceProfit profit;
    private final BalanceOperationId operationId;

    private final BalanceCreatedAt createdAt;
    private final BalanceUpdatedAt updatedAt;
    private final OperationType operationType;
    private final BalanceQuantityOperation quantityOperation;

    public Balance(String id, Float profit, String operationId, Date createdAt, Date updatedAt, String operationType, Float quantityOperation) {
        this.id = new BalanceId(id);
        this.profit = new BalanceProfit(profit);
        this.operationId = new BalanceOperationId(operationId);
        this.createdAt = new BalanceCreatedAt(createdAt);
        this.updatedAt = new BalanceUpdatedAt(updatedAt);
        this.operationType = OperationType.returnOperationTypeByDescription(operationType);
        this.quantityOperation = new BalanceQuantityOperation(quantityOperation);
    }

    public String getId() {
        return id.value();
    }

    public Float getProfit() {
        return profit.value();
    }

    public String getOperationId() {
        return operationId.value();
    }
    public Date getCreatedAt(){
        return createdAt.value();
    }
    public Date getUpdatedAt(){
        return updatedAt.value();
    }
    public String getOperationType(){
        return operationType.value();
    }
    public Float getQuantityOperation(){
        return quantityOperation.value();
    }
}
