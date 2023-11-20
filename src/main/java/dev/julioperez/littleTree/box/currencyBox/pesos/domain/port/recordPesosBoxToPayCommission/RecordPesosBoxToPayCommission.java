package dev.julioperez.littleTree.box.currencyBox.pesos.domain.port.recordPesosBoxToPayCommission;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;

public interface RecordPesosBoxToPayCommission {
    CurrencyMultiBox execute(CurrencyMultiBox pesosBox, Float sellerCommissionQuantity);
}
