package dev.julioperez.littleTree.box.currencyBox.officeDebt.application.payDebt.delivery;

import dev.julioperez.littleTree.box.currencyBox.officeDebt.domain.dto.PayDebtRequest;
import dev.julioperez.littleTree.box.currencyBox.officeDebt.domain.port.payDebt.PayDebt;
import dev.julioperez.littleTree.box.currencyBox.officeDebt.domain.port.payDebt.PayDebtInputPort;

public class PayDebtDelivery implements PayDebtInputPort {
    private final PayDebt payDebt;

    public PayDebtDelivery(PayDebt payDebt) {
        this.payDebt = payDebt;
    }

    @Override
    public boolean execute(PayDebtRequest payDebtRequest) {
        return payDebt.execute(payDebtRequest);
    }
}
