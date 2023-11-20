package dev.julioperez.littleTree.box.currencyBox.foreignExchange.domain.port.recordForeignExchangeToConfirmEgress;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;

public interface RecordForeignExchangeToConfirmEgress {
    CurrencyMultiBox execute(CurrencyMultiBox foreignExchangeBox, SellOperation sellOperation);
}
