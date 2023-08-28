package dev.julioperez.littleTree.box.domain.model;

import dev.julioperez.littleTree.operation.domain.model.operation.OperationId;


public final class Balance {

    private final BalanceId id;
    private final BalanceProfit profit;
    private final OperationId operationId;

    public Balance(String id, Float profit, String operationId) {
        this.id = new BalanceId(id);
        this.profit = new BalanceProfit(profit);
        this.operationId = new OperationId(operationId);
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
}
