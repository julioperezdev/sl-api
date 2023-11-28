package dev.julioperez.littleTree.box.currencyBox.foreignExchange.domain.port.recordForeignExchangeToConfirmIngress;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.dto.LastQuantityAndQuantityViewed;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;

public interface RecordForeignExchangeToConfirmIngress {
    CurrencyMultiBox execute(CurrencyMultiBox foreignExchangeBox, BuyOperation buyOperation, LastQuantityAndQuantityViewed actualQuantityAndQuantityViewedByForeignExchangeBox);
}
