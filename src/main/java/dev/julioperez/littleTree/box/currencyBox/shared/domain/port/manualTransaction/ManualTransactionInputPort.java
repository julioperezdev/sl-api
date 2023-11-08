package dev.julioperez.littleTree.box.currencyBox.shared.domain.port.manualTransaction;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.dto.ManualTransactionRequest;

public interface ManualTransactionInputPort {
    boolean execute(ManualTransactionRequest manualTransactionRequest);
}
