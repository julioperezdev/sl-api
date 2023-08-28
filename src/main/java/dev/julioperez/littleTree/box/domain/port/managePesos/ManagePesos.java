package dev.julioperez.littleTree.box.domain.port.managePesos;

import dev.julioperez.littleTree.box.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.operation.domain.model.buyOperation.BuyOperation;
import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperation;

public interface ManagePesos {
    CurrencyMultiBox recordPendingPesosBoxToEgress(CurrencyMultiBox pesosBox, BuyOperation buyOperation);
    CurrencyMultiBox recordPendingPesosBoxToIngress(CurrencyMultiBox pesosBox, SellOperation sellOperation);
    CurrencyMultiBox recordPesosBoxToReturnEgress(CurrencyMultiBox pesosBox, BuyOperation buyOperation, Float actualQuantityOfPesosBox);
    CurrencyMultiBox recordPesosBoxToConfirmEgress(CurrencyMultiBox pesosBox, BuyOperation buyOperation, Float actualQuantityOfPesosBox);
    CurrencyMultiBox recordPesosBoxToConfirmIngress(CurrencyMultiBox pesosBox, SellOperation sellOperation);
}
