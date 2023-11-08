package dev.julioperez.littleTree.box.currencyBox.shared.application.manualTransaction.delivery;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.dto.ManualTransactionRequest;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.manualTransaction.ManualTransaction;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.manualTransaction.ManualTransactionInputPort;

public class ManualTransactionDelivery implements ManualTransactionInputPort {
    private final ManualTransaction manualTransaction;

    public ManualTransactionDelivery(ManualTransaction manualTransaction) {
        this.manualTransaction = manualTransaction;
    }

    @Override
    public boolean execute(ManualTransactionRequest manualTransactionRequest) {
        return manualTransaction.execute(manualTransactionRequest);
    }
}
