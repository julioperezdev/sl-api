package dev.julioperez.littleTree.box.currencyBox.pesos.domain.port.managePesos;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;

public interface ManagePesos {
    CurrencyMultiBox recordPendingPesosBoxToEgress(CurrencyMultiBox pesosBox, BuyOperation buyOperation);
    CurrencyMultiBox recordPendingPesosBoxToIngress(CurrencyMultiBox pesosBox, SellOperation sellOperation);
    CurrencyMultiBox recordPesosBoxToReturnEgress(CurrencyMultiBox pesosBox, BuyOperation buyOperation, Float actualQuantityOfPesosBox);
    CurrencyMultiBox recordPesosBoxToConfirmEgress(CurrencyMultiBox pesosBox, BuyOperation buyOperation, Float actualQuantityOfPesosBox);
    CurrencyMultiBox recordPesosBoxToConfirmIngress(CurrencyMultiBox pesosBox, SellOperation sellOperation);
    CurrencyMultiBox recordPesosBoxToPayCommission(CurrencyMultiBox pesosBox, Float sellerCommissionQuantity);
}
