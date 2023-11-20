package dev.julioperez.littleTree.box.currencyBox.pesos.domain.port.recordPesosBoxToConfirmIngress;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;

public interface RecordPesosBoxToConfirmIngress {
    CurrencyMultiBox execute(CurrencyMultiBox pesosBox, SellOperation sellOperation);
}
