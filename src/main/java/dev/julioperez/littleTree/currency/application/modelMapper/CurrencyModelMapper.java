package dev.julioperez.littleTree.currency.application.modelMapper;

import dev.julioperez.littleTree.currency.domain.dto.UpdateCurrencyRequest;
import dev.julioperez.littleTree.currency.domain.model.Currency;
import dev.julioperez.littleTree.currency.domain.port.mapper.CurrencyMapper;
import dev.julioperez.littleTree.currency.infrastructure.repository.entity.CurrencyEntity;

import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class CurrencyModelMapper implements CurrencyMapper {

    @Override
    public Currency toCurrencyModel(UpdateCurrencyRequest updateCurrencyRequest) {
        return new Currency(
                UUID.randomUUID().toString(),
                updateCurrencyRequest.name(),
                updateCurrencyRequest.buyPrice(),
                updateCurrencyRequest.sellPrice(),
                Date.from(Instant.now()));
    }

    @Override
    public Currency toCurrencyModel(CurrencyEntity currencyEntity) {
        return new Currency(
                currencyEntity.getId(),
                currencyEntity.getName(),
                currencyEntity.getBuyPrice(),
                currencyEntity.getSellPrice(),
                currencyEntity.getUpdateAt());
    }

    @Override
    public List<Currency> toCurrenciesModel(List<CurrencyEntity> currencyEntities) {
        return currencyEntities
                .stream()
                .map(this::toCurrencyModel)
                .toList();
    }

    @Override
    public CurrencyEntity toCurrencyEntity(Currency currency) {
        return new CurrencyEntity(
                currency.getId(),
                currency.getName(),
                currency.getBuyPrice(),
                currency.getSellPrice(),
                currency.getUpdateAt());
    }
}
