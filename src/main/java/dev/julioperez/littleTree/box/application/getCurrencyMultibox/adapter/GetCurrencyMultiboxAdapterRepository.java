package dev.julioperez.littleTree.box.application.getCurrencyMultibox.adapter;

import dev.julioperez.littleTree.box.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.domain.port.getCurrencyMultibox.GetCurrencyMultiboxOutputPort;
import dev.julioperez.littleTree.box.domain.port.mapper.CurrencyMultiBoxMapper;
import dev.julioperez.littleTree.box.infrastructure.repository.dao.CurrencyMultiBoxDao;
import dev.julioperez.littleTree.box.infrastructure.repository.entity.CurrencyMultiBoxEntity;

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
}
