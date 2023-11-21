package dev.julioperez.littleTree.box.currencyBox.shared.application.updateCurrenciesMultiboxBoxes.adapter;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.mapper.CurrencyMultiBoxMapper;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.updateCurrenciesMultiboxBoxes.UpdateCurrenciesMultiboxBoxesOutputPort;
import dev.julioperez.littleTree.box.currencyBox.shared.infrastructure.repository.dao.CurrencyMultiBoxDao;
import dev.julioperez.littleTree.box.currencyBox.shared.infrastructure.repository.entity.CurrencyMultiBoxEntity;

import java.util.List;

public class UpdateCurrenciesMultiboxBoxesAdapterRepository implements UpdateCurrenciesMultiboxBoxesOutputPort {
    private final CurrencyMultiBoxDao currencyMultiBoxDao;
    private final CurrencyMultiBoxMapper currencyMultiBoxMapper;

    public UpdateCurrenciesMultiboxBoxesAdapterRepository(CurrencyMultiBoxDao currencyMultiBoxDao, CurrencyMultiBoxMapper currencyMultiBoxMapper) {
        this.currencyMultiBoxDao = currencyMultiBoxDao;
        this.currencyMultiBoxMapper = currencyMultiBoxMapper;
    }

    @Override
    public List<CurrencyMultiBox> saveCurrencyMultiBox(List<CurrencyMultiBox> newCurrenciesMultiBoxes) {
        List<CurrencyMultiBoxEntity> currencyMultiBoxesEntity = currencyMultiBoxMapper.toCurrencyMultiBoxesEntity(newCurrenciesMultiBoxes);
        List<CurrencyMultiBoxEntity> currencyMultiBoxEntities = currencyMultiBoxDao.saveAll(currencyMultiBoxesEntity);
        return currencyMultiBoxMapper.toCurrencyMultiBoxesModel(currencyMultiBoxEntities);
    }
}
