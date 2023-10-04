package dev.julioperez.littleTree.box.domain.model;


public final class Balance {

    private final BalanceId id;
    private final BalanceProfit profit;
    private final BalanceOperationId operationId;

    public Balance(String id, Float profit, String operationId) {
        this.id = new BalanceId(id);
        this.profit = new BalanceProfit(profit);
        this.operationId = new BalanceOperationId(operationId);
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
