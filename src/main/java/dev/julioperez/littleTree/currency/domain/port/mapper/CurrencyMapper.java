package dev.julioperez.littleTree.currency.domain.port.mapper;

import dev.julioperez.littleTree.currency.domain.dto.UpdateCurrencyRequest;
import dev.julioperez.littleTree.currency.domain.model.Currency;
import dev.julioperez.littleTree.currency.infrastructure.repository.entity.CurrencyEntity;

import java.util.List;

public interface CurrencyMapper {
    Currency toCurrencyModel(UpdateCurrencyRequest updateCurrencyRequest);
    Currency toCurrencyModel(CurrencyEntity currencyEntity);
    List<Currency> toCurrenciesModel(List<CurrencyEntity> currencyEntities);
    CurrencyEntity toCurrencyEntity(Currency currency);
}
