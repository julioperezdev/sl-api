package dev.julioperez.littleTree.currency.application.getCurrency.adapter;

import dev.julioperez.littleTree.currency.domain.model.Currency;
import dev.julioperez.littleTree.currency.domain.port.getCurrency.GetCurrencyOutputPort;
import dev.julioperez.littleTree.currency.domain.port.mapper.CurrencyMapper;
import dev.julioperez.littleTree.currency.infrastructure.repository.dao.CurrencyDao;
import dev.julioperez.littleTree.currency.infrastructure.repository.entity.CurrencyEntity;

import java.util.List;

public class GetCurrencyAdapterRepository implements GetCurrencyOutputPort {
    private final CurrencyDao currencyDao;
    private final CurrencyMapper currencyMapper;

    public GetCurrencyAdapterRepository(CurrencyDao currencyDao, CurrencyMapper currencyMapper) {
        this.currencyDao = currencyDao;
        this.currencyMapper = currencyMapper;
    }

    @Override
    public List<Currency> getCurrencies() {
        List<CurrencyEntity> currencyEntities = currencyDao.findAll();
        return currencyMapper.toCurrenciesModel(currencyEntities);
    }

    @Override
    public List<Currency> getLastUpdateOfCurrencies() {
        List<CurrencyEntity> lastUpdatedCurrencies = currencyDao.findLastUpdatedCurrencies();
        return currencyMapper.toCurrenciesModel(lastUpdatedCurrencies);
    }

    @Override
    public Currency getLastUpdatedByName(String name) {
        CurrencyEntity lastUpdatedByName = currencyDao.getLastUpdatedByName(name).orElseThrow(() -> new IllegalArgumentException(String.format("Does not exist %s currency name", name)));
        return currencyMapper.toCurrencyModel(lastUpdatedByName);
    }
}
