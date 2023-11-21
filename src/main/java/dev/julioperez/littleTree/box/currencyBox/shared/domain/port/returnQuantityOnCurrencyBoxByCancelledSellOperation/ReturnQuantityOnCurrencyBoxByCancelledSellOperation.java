package dev.julioperez.littleTree.box.currencyBox.shared.domain.port.returnQuantityOnCurrencyBoxByCancelledSellOperation;

import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;

public interface ReturnQuantityOnCurrencyBoxByCancelledSellOperation {
    boolean execute(SellOperation sellOperation);
}
