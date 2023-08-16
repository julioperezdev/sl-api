package dev.julioperez.littleTree.currency.application.updateCurrency.adapter;

import dev.julioperez.littleTree.currency.domain.model.Currency;
import dev.julioperez.littleTree.currency.domain.port.mapper.CurrencyMapper;
import dev.julioperez.littleTree.currency.domain.port.updateCurrency.UpdateCurrencyOutputPort;
import dev.julioperez.littleTree.currency.infrastructure.repository.dao.CurrencyDao;
import dev.julioperez.littleTree.currency.infrastructure.repository.entity.CurrencyEntity;

import java.util.List;

public class UpdateCurrencyAdapterRepository implements UpdateCurrencyOutputPort {
    private final CurrencyDao currencyDao;
    private final CurrencyMapper currencyMapper;

    public UpdateCurrencyAdapterRepository(CurrencyDao currencyDao, CurrencyMapper currencyMapper) {
        this.currencyDao = currencyDao;
        this.currencyMapper = currencyMapper;
    }

    @Override
    public void updateCurrency(Currency currency) {
        CurrencyEntity currencyEntity = currencyMapper.toCurrencyEntity(currency);
        currencyDao.save(currencyEntity);
    }
}
