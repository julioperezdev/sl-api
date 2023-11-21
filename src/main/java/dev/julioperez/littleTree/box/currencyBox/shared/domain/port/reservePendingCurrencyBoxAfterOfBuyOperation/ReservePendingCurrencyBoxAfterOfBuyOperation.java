package dev.julioperez.littleTree.box.currencyBox.shared.domain.port.reservePendingCurrencyBoxAfterOfBuyOperation;

import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;

import java.util.List;

public interface ReservePendingCurrencyBoxAfterOfBuyOperation {
    boolean execute(List<BuyOperation> buyOperations);
}
