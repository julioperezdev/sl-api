package dev.julioperez.littleTree.currency.domain.port.getCurrency;

import dev.julioperez.littleTree.currency.domain.model.Currency;

import java.util.List;

public interface GetCurrency {
    List<Currency> getHistoricalCurrencies();
    List<Currency> getLastUpdateOfCurrencies();
}
