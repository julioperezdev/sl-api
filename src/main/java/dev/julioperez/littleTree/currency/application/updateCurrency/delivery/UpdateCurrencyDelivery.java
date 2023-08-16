package dev.julioperez.littleTree.currency.application.updateCurrency.delivery;

import dev.julioperez.littleTree.currency.domain.dto.UpdateCurrencyRequest;
import dev.julioperez.littleTree.currency.domain.model.Currency;
import dev.julioperez.littleTree.currency.domain.port.updateCurrency.UpdateCurrency;
import dev.julioperez.littleTree.currency.domain.port.updateCurrency.UpdateCurrencyInputPort;

import java.util.List;

public class UpdateCurrencyDelivery implements UpdateCurrencyInputPort {
    private final UpdateCurrency updateCurrency;

    public UpdateCurrencyDelivery(UpdateCurrency updateCurrency) {
        this.updateCurrency = updateCurrency;
    }

    @Override
    public List<Currency> updateCurrency(UpdateCurrencyRequest updateCurrencyRequest) {
        return updateCurrency.updateCurrency(updateCurrencyRequest);
    }
}
