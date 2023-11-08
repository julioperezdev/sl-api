package dev.julioperez.littleTree.box.currencyBox.officeDebt.application.getOfficeDebt.delivery;

import dev.julioperez.littleTree.box.currencyBox.officeDebt.domain.port.getOfficeDebt.GetOfficeDebt;
import dev.julioperez.littleTree.box.currencyBox.officeDebt.domain.port.getOfficeDebt.GetOfficeDebtInputPort;

public class GetOfficeDebtDelivery implements GetOfficeDebtInputPort {
    private final GetOfficeDebt getOfficeDebt;

    public GetOfficeDebtDelivery(GetOfficeDebt getOfficeDebt) {
        this.getOfficeDebt = getOfficeDebt;
    }

    @Override
    public Float getLastDebt() {
        return getOfficeDebt.getLastDebt();
    }
}
