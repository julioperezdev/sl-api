package dev.julioperez.littleTree.box.currencyBox.officeDebt.domain.port.payDebt;

import dev.julioperez.littleTree.box.currencyBox.officeDebt.domain.dto.PayDebtRequest;

public interface PayDebtInputPort {
    boolean execute(PayDebtRequest payDebtRequest);
}
