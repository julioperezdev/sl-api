package dev.julioperez.littleTree.box.domain.port.manageForeignExchange;

import dev.julioperez.littleTree.box.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.operation.domain.model.buyOperation.BuyOperation;
import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperation;

public interface ManageForeignExchange {
    CurrencyMultiBox recordPendingForeignExchangeToIngress(CurrencyMultiBox foreignExchangeBox, BuyOperation buyOperation);
    CurrencyMultiBox recordPendingForeignExchangeToEgress(CurrencyMultiBox foreignExchangeBox, SellOperation sellOperation);
    CurrencyMultiBox recordForeignExchangeBoxToReturnEgress(CurrencyMultiBox foreignExchangeBox, SellOperation sellOperation, Float actualQuantityByExchangeCurrencyBox);
    CurrencyMultiBox recordForeignExchangeToConfirmIngress(CurrencyMultiBox foreignExchangeBox, BuyOperation buyOperation, Float actualQuantityByForeignExchangeBox);
    CurrencyMultiBox recordForeignExchangeToConfirmEgress(CurrencyMultiBox foreignExchangeBox, SellOperation sellOperation);


}
