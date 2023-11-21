package dev.julioperez.littleTree.box.currencyBox.shared.domain.port.reserveDoneCurrencyBoxAfterOfConfirmBuyOperation;

import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;

public interface ReserveDoneCurrencyBoxAfterOfConfirmBuyOperation {
    boolean execute(BuyOperation buyOperation);
}
