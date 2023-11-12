package dev.julioperez.littleTree.box.currencyBox.foreignExchange.domain.port.manageForeignExchange;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;

public interface ManageForeignExchange {
    CurrencyMultiBox recordPendingForeignExchangeToIngress(CurrencyMultiBox foreignExchangeBox, BuyOperation buyOperation);
    CurrencyMultiBox recordPendingForeignExchangeToEgress(CurrencyMultiBox foreignExchangeBox, SellOperation sellOperation);
    CurrencyMultiBox recordForeignExchangeBoxToReturnEgress(CurrencyMultiBox foreignExchangeBox, SellOperation sellOperation, Float actualQuantityByExchangeCurrencyBox);
    CurrencyMultiBox recordForeignExchangeToConfirmIngress(CurrencyMultiBox foreignExchangeBox, BuyOperation buyOperation, Float actualQuantityByForeignExchangeBox);
    CurrencyMultiBox recordForeignExchangeToConfirmEgress(CurrencyMultiBox foreignExchangeBox, SellOperation sellOperation);


}
