package dev.julioperez.littleTree.box.currencyBox.shared.domain.port.returnQuantityOnCurrencyBoxByCancelledBuyOperation;

import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;

public interface ReturnQuantityOnCurrencyBoxByCancelledBuyOperation {
    boolean execute(BuyOperation buyOperation);
}
