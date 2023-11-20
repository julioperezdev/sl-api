package dev.julioperez.littleTree.box.currencyBox.foreignExchange.domain.port.recordPendingForeignExchangeToEgress;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;

public interface RecordPendingForeignExchangeToEgress {
    CurrencyMultiBox execute(CurrencyMultiBox foreignExchangeBox, SellOperation sellOperation);
}
