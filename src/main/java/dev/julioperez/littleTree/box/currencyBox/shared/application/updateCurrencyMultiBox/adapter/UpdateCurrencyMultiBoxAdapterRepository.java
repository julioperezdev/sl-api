package dev.julioperez.littleTree.box.currencyBox.shared.application.updateCurrencyMultiBox.adapter;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.mapper.CurrencyMultiBoxMapper;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.updateCurrencyMultiBox.UpdateCurrencyMultiBoxOutputPort;
import dev.julioperez.littleTree.box.currencyBox.shared.infrastructure.repository.dao.CurrencyMultiBoxDao;
import dev.julioperez.littleTree.box.currencyBox.shared.infrastructure.repository.entity.CurrencyMultiBoxEntity;

import java.util.List;
import java.util.Optional;

public class UpdateCurrencyMultiBoxAdapterRepository implements UpdateCurrencyMultiBoxOutputPort {
    private final CurrencyMultiBoxDao currencyMultiBoxDao;
    private final CurrencyMultiBoxMapper currencyMultiBoxMapper;

    public UpdateCurrencyMultiBoxAdapterRepository(CurrencyMultiBoxDao currencyMultiBoxDao, CurrencyMultiBoxMapper currencyMultiBoxMapper) {
        this.currencyMultiBoxDao = currencyMultiBoxDao;
        this.currencyMultiBoxMapper = currencyMultiBoxMapper;
    }

//    public CurrencyMultiBox currencyMultiBox(CurrencyMultiBox currencyMultiBox){
//        CurrencyMultiBoxEntity currencyMultiBoxEntity = currencyMultiBoxMapper.toCurrencyMultiBoxEntity(currencyMultiBox);
//        currencyMultiBoxDao.save(currencyMultiBoxEntity);
//        return currencyMultiBoxMapper.toCurrencyMultiBoxModel(currencyMultiBoxEntity);
//    }

    @Override
    public List<CurrencyMultiBox> currencyMultiBoxes(List<CurrencyMultiBox> currencyMultiBoxes) {
        List<CurrencyMultiBoxEntity> currencyMultiBoxesEntity = currencyMultiBoxMapper.toCurrencyMultiBoxesEntity(currencyMultiBoxes);
        currencyMultiBoxDao.saveAll(currencyMultiBoxesEntity);
        return currencyMultiBoxMapper.toCurrencyMultiBoxesModel(currencyMultiBoxesEntity);
    }

    @Override
    public List<CurrencyMultiBox> getCurrenciesMultiboxByValues(List<String> currencyMultiBoxValues) {
        Optional<List<CurrencyMultiBoxEntity>> result = currencyMultiBoxDao.getDistinctByCurrencyBoxInOrderByUpdatedAtDesc(currencyMultiBoxValues);
        if(result.isEmpty()) throw new IllegalArgumentException("getCurrenciesMultiboxByValues does not return values with params assigned");
        return currencyMultiBoxMapper.toCurrencyMultiBoxesModel(result.get());
    }

    @Override
    public List<CurrencyMultiBox> getCurrenciesMultiboxByOperationId(String operationId) {
        Optional<List<CurrencyMultiBoxEntity>> byOperationId = currencyMultiBoxDao.getByOperationId(operationId);
        if(byOperationId.isEmpty()) throw new IllegalArgumentException(String.format("getCurrenciesMultiboxByOperationId does not return values with Operation ID %s", operationId));
        if(byOperationId.get().size() != 2) throw new IllegalArgumentException(String.format("getCurrenciesMultiboxByOperationId should return two values to Operation ID %s", operationId));
        return currencyMultiBoxMapper.toCurrencyMultiBoxesModel(byOperationId.get());
    }

    @Override
    public CurrencyMultiBox getActualQuantityByCurrencyBox(CurrencyBox currencyBox) {
        Optional<CurrencyMultiBoxEntity> optionalCurrencyBox = currencyMultiBoxDao.getFirstByCurrencyBoxOrderByUpdatedAtDesc(currencyBox.value());
        if(optionalCurrencyBox.isEmpty()) throw new IllegalArgumentException(String.format("getActualQuantityByCurrencyBox does not return value with description %s", currencyBox.value()));
        return currencyMultiBoxMapper.toCurrencyMultiBoxModel(optionalCurrencyBox.get());
    }

    @Override
    public List<CurrencyMultiBox> saveCurrencyMultiBox(List<CurrencyMultiBox> newCurrenciesMultiBoxes) {
        List<CurrencyMultiBoxEntity> currencyMultiBoxesEntity = currencyMultiBoxMapper.toCurrencyMultiBoxesEntity(newCurrenciesMultiBoxes);
        List<CurrencyMultiBoxEntity> currencyMultiBoxEntities = currencyMultiBoxDao.saveAll(currencyMultiBoxesEntity);
        return currencyMultiBoxMapper.toCurrencyMultiBoxesModel(currencyMultiBoxEntities);
    }
}
