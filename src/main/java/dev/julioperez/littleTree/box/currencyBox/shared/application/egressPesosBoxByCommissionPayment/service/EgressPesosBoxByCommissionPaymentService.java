package dev.julioperez.littleTree.box.currencyBox.shared.application.egressPesosBoxByCommissionPayment.service;

import dev.julioperez.littleTree.box.currencyBox.pesos.domain.port.recordPesosBoxToPayCommission.RecordPesosBoxToPayCommission;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.egressPesosBoxByCommissionPayment.EgressPesosBoxByCommissionPayment;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.getCurrencyMultibox.GetCurrencyMultibox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.updateCurrenciesMultiboxBoxes.UpdateCurrenciesMultiboxBoxes;

import java.util.List;

public class EgressPesosBoxByCommissionPaymentService implements EgressPesosBoxByCommissionPayment {
    private final GetCurrencyMultibox getCurrencyMultibox;
    private final UpdateCurrenciesMultiboxBoxes updateCurrenciesMultiboxBoxes;
    private final RecordPesosBoxToPayCommission recordPesosBoxToPayCommission;

    public EgressPesosBoxByCommissionPaymentService(GetCurrencyMultibox getCurrencyMultibox, UpdateCurrenciesMultiboxBoxes updateCurrenciesMultiboxBoxes, RecordPesosBoxToPayCommission recordPesosBoxToPayCommission) {
        this.getCurrencyMultibox = getCurrencyMultibox;
        this.updateCurrenciesMultiboxBoxes = updateCurrenciesMultiboxBoxes;
        this.recordPesosBoxToPayCommission = recordPesosBoxToPayCommission;
    }

    @Override
    public boolean execute(Float sellerCommissionQuantity) {
        try {
            CurrencyMultiBox lastCurrencyMultiboxByCurrencyBox = getCurrencyMultibox.getLastCurrencyMultiboxByCurrencyBox(CurrencyBox.PESO);
            CurrencyMultiBox currencyMultiBox = recordPesosBoxToPayCommission.execute(lastCurrencyMultiboxByCurrencyBox, sellerCommissionQuantity);
            updateCurrenciesMultiboxBoxes.execute(List.of(currencyMultiBox));
            return true;
        }catch (Exception exception){
            return false;
        }
    }
}
