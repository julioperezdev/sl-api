package dev.julioperez.littleTree.box.domain.model;


import java.util.Date;

public final class Balance {

    private final BalanceId id;
    private final BalanceProfit profit;
    private final BalanceOperationId operationId;

    private final BalanceCreatedAt createdAt;
    private final BalanceUpdatedAt updatedAt;

    public Balance(String id, Float profit, String operationId, Date createdAt, Date updatedAt) {
        this.id = new BalanceId(id);
        this.profit = new BalanceProfit(profit);
        this.operationId = new BalanceOperationId(operationId);
        this.createdAt = new BalanceCreatedAt(createdAt);
        this.updatedAt = new BalanceUpdatedAt(updatedAt);
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
}
