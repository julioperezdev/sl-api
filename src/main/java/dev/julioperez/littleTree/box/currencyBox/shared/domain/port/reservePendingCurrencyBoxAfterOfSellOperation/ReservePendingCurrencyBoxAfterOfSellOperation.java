package dev.julioperez.littleTree.box.currencyBox.shared.domain.port.reservePendingCurrencyBoxAfterOfSellOperation;

import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;

import java.util.List;

public interface ReservePendingCurrencyBoxAfterOfSellOperation {
    boolean execute(List<SellOperation> sellOperations);
}
