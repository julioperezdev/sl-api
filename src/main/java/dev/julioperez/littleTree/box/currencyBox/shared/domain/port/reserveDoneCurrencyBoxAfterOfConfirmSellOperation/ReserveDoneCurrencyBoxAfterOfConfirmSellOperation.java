package dev.julioperez.littleTree.box.currencyBox.shared.domain.port.reserveDoneCurrencyBoxAfterOfConfirmSellOperation;

import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;

public interface ReserveDoneCurrencyBoxAfterOfConfirmSellOperation {
    boolean execute(SellOperation sellOperation);
}
