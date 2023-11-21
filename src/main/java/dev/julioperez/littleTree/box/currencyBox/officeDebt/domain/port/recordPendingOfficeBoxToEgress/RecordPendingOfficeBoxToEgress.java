package dev.julioperez.littleTree.box.currencyBox.officeDebt.domain.port.recordPendingOfficeBoxToEgress;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;

public interface RecordPendingOfficeBoxToEgress {
    CurrencyMultiBox execute(CurrencyMultiBox officeBox, BuyOperation buyOperation);
}
