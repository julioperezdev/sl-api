package dev.julioperez.littleTree.currency.application.updateCurrency.service;

import dev.julioperez.littleTree.currency.domain.dto.UpdateCurrencyRequest;
import dev.julioperez.littleTree.currency.domain.model.Currency;
import dev.julioperez.littleTree.currency.domain.port.getCurrency.GetCurrency;
import dev.julioperez.littleTree.currency.domain.port.mapper.CurrencyMapper;
import dev.julioperez.littleTree.currency.domain.port.updateCurrency.UpdateCurrency;
import dev.julioperez.littleTree.currency.domain.port.updateCurrency.UpdateCurrencyOutputPort;

import java.util.List;

public class UpdateCurrencyService implements UpdateCurrency {
    private final UpdateCurrencyOutputPort updateCurrencyOutputPort;
    private final GetCurrency getCurrency;
    private final CurrencyMapper currencyMapper;

    public UpdateCurrencyService(UpdateCurrencyOutputPort updateCurrencyOutputPort, GetCurrency getCurrency, CurrencyMapper currencyMapper) {
        this.updateCurrencyOutputPort = updateCurrencyOutputPort;
        this.getCurrency = getCurrency;
        this.currencyMapper = currencyMapper;
    }

    @Override
    public List<Currency> updateCurrency(UpdateCurrencyRequest updateCurrencyRequest) {
        Currency currencyToUpdate = currencyMapper.toCurrencyModel(updateCurrencyRequest);
        updateCurrencyOutputPort.updateCurrency(currencyToUpdate);
        return getCurrency.getLastUpdateOfCurrencies();
    }
}
