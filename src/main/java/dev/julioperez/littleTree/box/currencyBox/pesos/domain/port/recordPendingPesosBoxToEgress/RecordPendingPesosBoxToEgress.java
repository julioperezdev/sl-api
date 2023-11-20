package dev.julioperez.littleTree.box.currencyBox.pesos.domain.port.recordPendingPesosBoxToEgress;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;

public interface RecordPendingPesosBoxToEgress {
    CurrencyMultiBox execute(CurrencyMultiBox pesosBox, BuyOperation buyOperation);
}
