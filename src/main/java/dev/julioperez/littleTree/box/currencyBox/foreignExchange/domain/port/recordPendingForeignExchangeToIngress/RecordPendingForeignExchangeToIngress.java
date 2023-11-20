package dev.julioperez.littleTree.box.currencyBox.foreignExchange.domain.port.recordPendingForeignExchangeToIngress;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;

public interface RecordPendingForeignExchangeToIngress {
    CurrencyMultiBox execute(CurrencyMultiBox foreignExchangeBox, BuyOperation buyOperation);
}
