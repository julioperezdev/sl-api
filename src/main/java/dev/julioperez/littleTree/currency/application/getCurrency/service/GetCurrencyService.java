package dev.julioperez.littleTree.currency.application.getCurrency.service;

import dev.julioperez.littleTree.currency.domain.model.Currency;
import dev.julioperez.littleTree.currency.domain.port.getCurrency.GetCurrency;
import dev.julioperez.littleTree.currency.domain.port.getCurrency.GetCurrencyOutputPort;

import java.util.List;

public class GetCurrencyService implements GetCurrency {
    private final GetCurrencyOutputPort getCurrencyOutputPort;

    public GetCurrencyService(GetCurrencyOutputPort getCurrencyOutputPort) {
        this.getCurrencyOutputPort = getCurrencyOutputPort;
    }

    @Override
    public List<Currency> getHistoricalCurrencies() {
        //Falta definir como se quiere retornar la informacion
        return getCurrencyOutputPort.getCurrencies();
    }

    @Override
    public List<Currency> getLastUpdateOfCurrencies() {
        List<Currency> lastUpdateOfCurrencies = getCurrencyOutputPort.getLastUpdateOfCurrencies();
        isValidLastUpdateOfCurrencies(lastUpdateOfCurrencies);
        return lastUpdateOfCurrencies;
    }
    private void isValidLastUpdateOfCurrencies(List<Currency> lastUpdateOfCurrencies){
        if(lastUpdateOfCurrencies.size() != 4) throw new IllegalArgumentException("Dont have a same quantity of Currencies");
        boolean distinctCurrencies = lastUpdateOfCurrencies.stream().distinct().toList().size() == 4;
        if(!distinctCurrencies) throw new IllegalArgumentException("Cant repeat name of Currencies");
    }

}
