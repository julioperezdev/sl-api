package dev.julioperez.littleTree.box.currencyBox.officeDebt.application.getOfficeDebt.service;

import dev.julioperez.littleTree.box.currencyBox.officeDebt.domain.port.getOfficeDebt.GetOfficeDebt;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.getCurrencyMultibox.GetCurrencyMultibox;

public class GetOfficeDebtService implements GetOfficeDebt {

    private final GetCurrencyMultibox getCurrencyMultibox;

    public GetOfficeDebtService(GetCurrencyMultibox getCurrencyMultibox) {
        this.getCurrencyMultibox = getCurrencyMultibox;
    }

    @Override
    public Float getLastDebt() {
        return getCurrencyMultibox.getTotalByCurrencyBox(CurrencyBox.PESO_OFFICE);
    }
}
