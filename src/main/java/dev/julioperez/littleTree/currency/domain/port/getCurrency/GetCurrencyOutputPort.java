package dev.julioperez.littleTree.currency.domain.port.getCurrency;

import dev.julioperez.littleTree.currency.domain.model.Currency;

import java.util.List;

public interface GetCurrencyOutputPort {
    List<Currency> getCurrencies();
    List<Currency> getLastUpdateOfCurrencies();
}
