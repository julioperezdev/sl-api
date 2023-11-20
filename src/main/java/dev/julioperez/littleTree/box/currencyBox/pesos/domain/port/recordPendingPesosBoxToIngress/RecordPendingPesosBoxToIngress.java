package dev.julioperez.littleTree.box.currencyBox.pesos.domain.port.recordPendingPesosBoxToIngress;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;

public interface RecordPendingPesosBoxToIngress {
    CurrencyMultiBox execute(CurrencyMultiBox pesosBox, SellOperation sellOperation);
}
