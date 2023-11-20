package dev.julioperez.littleTree.box.currencyBox.foreignExchange.domain.port.recordForeignExchangeBoxToReturnEgress;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;

public interface RecordForeignExchangeBoxToReturnEgress {
    CurrencyMultiBox execute(CurrencyMultiBox foreignExchangeBox, SellOperation sellOperation, Float actualQuantityByExchangeCurrencyBox);
}
