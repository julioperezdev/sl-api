package dev.julioperez.littleTree.box.currencyBox.shared.domain.port.mapper;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.currencyBox.shared.infrastructure.repository.entity.CurrencyMultiBoxEntity;

import java.util.List;

public interface CurrencyMultiBoxMapper {
    //CurrencyMultiBox toCurrencyMultiBoxModel(UpdateCurrencyMultiBoxRequest updateCurrencyMultiBoxRequest);
    CurrencyMultiBox toCurrencyMultiBoxModel(CurrencyMultiBoxEntity currencyMultiBoxEntity);
    List<CurrencyMultiBox> toCurrencyMultiBoxesModel(List<CurrencyMultiBoxEntity> currencyMultiBoxEntities);
    CurrencyMultiBoxEntity toCurrencyMultiBoxEntity(CurrencyMultiBox currencyMultiBox);
    List<CurrencyMultiBoxEntity> toCurrencyMultiBoxesEntity(List<CurrencyMultiBox> currencyMultiBoxes);
}
