package dev.julioperez.littleTree.box.currencyBox.pesos.domain.port.recordPesosBoxToConfirmEgress;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;

public interface RecordPesosBoxToConfirmEgress {
    CurrencyMultiBox execute(CurrencyMultiBox pesosBox, BuyOperation buyOperation, Float actualQuantityOfPesosBox);
}
