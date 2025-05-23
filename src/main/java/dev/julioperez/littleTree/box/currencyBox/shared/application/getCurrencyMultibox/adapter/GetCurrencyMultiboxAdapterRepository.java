package dev.julioperez.littleTree.box.currencyBox.shared.application.getCurrencyMultibox.adapter;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.MultiBoxStatus;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.getCurrencyMultibox.GetCurrencyMultiboxOutputPort;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.mapper.CurrencyMultiBoxMapper;
import dev.julioperez.littleTree.box.currencyBox.shared.infrastructure.repository.dao.CurrencyMultiBoxDao;
import dev.julioperez.littleTree.box.currencyBox.shared.infrastructure.repository.entity.CurrencyMultiBoxEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class GetCurrencyMultiboxAdapterRepository implements GetCurrencyMultiboxOutputPort {
    private final CurrencyMultiBoxDao currencyMultiBoxDao;
    private final CurrencyMultiBoxMapper currencyMultiBoxMapper;

    public GetCurrencyMultiboxAdapterRepository(CurrencyMultiBoxDao currencyMultiBoxDao, CurrencyMultiBoxMapper currencyMultiBoxMapper) {
        this.currencyMultiBoxDao = currencyMultiBoxDao;
        this.currencyMultiBoxMapper = currencyMultiBoxMapper;
    }

    @Override
    public List<CurrencyMultiBox> getCurrencyMultiboxByName(String name) {
        Optional<List<CurrencyMultiBoxEntity>> currencyBoxEntityOptional = currencyMultiBoxDao.getCurrencyMultiBoxEntitiesByCurrencyBoxOrderByUpdatedAtDesc(name);
        return currencyBoxEntityOptional.isEmpty()
                ? Collections.emptyList()
                : currencyMultiBoxMapper.toCurrencyMultiBoxesModel(currencyBoxEntityOptional.get());
    }

    @Override
    public CurrencyMultiBox getLastCurrencyMultiboxByCurrencyBox(CurrencyBox currencyBox) {
        Optional<CurrencyMultiBoxEntity> optionalCurrencyBox = currencyMultiBoxDao.getFirstByCurrencyBoxOrderByUpdatedAtDesc(currencyBox.value());
        return optionalCurrencyBox.map(currencyMultiBoxMapper::toCurrencyMultiBoxModel).orElse(null);
    }

    @Override
    public CurrencyMultiBox getLastCurrencyMultiboxByCurrencyBoxAndMultiboxStatus(CurrencyBox currencyBox, MultiBoxStatus multiBoxStatus) {
        Optional<CurrencyMultiBoxEntity> optionalResponse = currencyMultiBoxDao.getFirstByCurrencyBoxAndMultiBoxStatusOrderByUpdatedAtDesc(currencyBox.value(), multiBoxStatus.value());
        return optionalResponse.map(currencyMultiBoxMapper::toCurrencyMultiBoxModel).orElse(null);
    }

    @Override
    public List<CurrencyMultiBox> getCurrenciesMultiboxByOperationId(String operationId) {
        Optional<List<CurrencyMultiBoxEntity>> byOperationId = currencyMultiBoxDao.getByOperationId(operationId);
        if(byOperationId.isEmpty()) throw new IllegalArgumentException(String.format("getCurrenciesMultiboxByOperationId does not return values with Operation ID %s", operationId));
        if(byOperationId.get().size() != 2) throw new IllegalArgumentException(String.format("getCurrenciesMultiboxByOperationId should return two values to Operation ID %s", operationId));
        return currencyMultiBoxMapper.toCurrencyMultiBoxesModel(byOperationId.get());
    }

    @Override
    public List<CurrencyMultiBox> getCurrenciesMultiboxByValues(List<String> currencyMultiBoxValues) {
        Optional<List<CurrencyMultiBoxEntity>> result = currencyMultiBoxDao.getDistinctByCurrencyBoxInOrderByUpdatedAtDesc(currencyMultiBoxValues);
        if(result.isEmpty()) throw new IllegalArgumentException("getCurrenciesMultiboxByValues does not return values with params assigned");
        return currencyMultiBoxMapper.toCurrencyMultiBoxesModel(result.get());
    }
}
