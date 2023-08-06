package dev.julioperez.littleTree.box.domain.model;

import dev.julioperez.littleTree.operation.domain.model.OperationId;


public final class Balance {

    private final BalanceId id;
    private final BalanceProfit profit;
    private final OperationId operationId;

    public Balance(BalanceId id, BalanceProfit profit, OperationId operationId) {
        this.id = id;
        this.profit = profit;
        this.operationId = operationId;
    }
}
