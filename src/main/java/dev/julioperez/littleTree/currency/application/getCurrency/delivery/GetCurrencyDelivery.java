package dev.julioperez.littleTree.currency.application.getCurrency.delivery;

import dev.julioperez.littleTree.currency.domain.model.Currency;
import dev.julioperez.littleTree.currency.domain.port.getCurrency.GetCurrency;
import dev.julioperez.littleTree.currency.domain.port.getCurrency.GetCurrencyInputPort;

import java.util.List;

public class GetCurrencyDelivery implements GetCurrencyInputPort {
    private final GetCurrency getCurrency;

    public GetCurrencyDelivery(GetCurrency getCurrency) {
        this.getCurrency = getCurrency;
    }

    @Override
    public List<Currency> getHistoricalCurrencies() {
        return getCurrency.getHistoricalCurrencies();
    }

    @Override
    public List<Currency> getLastUpdateOfCurrencies() {
        return getCurrency.getLastUpdateOfCurrencies();
    }
}
