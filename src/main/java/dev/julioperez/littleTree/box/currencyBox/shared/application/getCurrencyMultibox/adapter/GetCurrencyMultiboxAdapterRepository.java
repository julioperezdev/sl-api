package dev.julioperez.littleTree.box.currencyBox.shared.application.getCurrencyMultibox.adapter;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.CurrencyBox;
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
}
