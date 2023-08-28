package dev.julioperez.littleTree.box.application.modelMapper;

import dev.julioperez.littleTree.box.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.domain.port.mapper.CurrencyMultiBoxMapper;
import dev.julioperez.littleTree.box.infrastructure.repository.entity.CurrencyMultiBoxEntity;

import java.util.List;

public class CurrencyMultiBoxModelMapper implements CurrencyMultiBoxMapper {

    @Override
    public CurrencyMultiBox toCurrencyMultiBoxModel(CurrencyMultiBoxEntity currencyMultiBoxEntity) {
        return new CurrencyMultiBox(
                currencyMultiBoxEntity.getId(),
                currencyMultiBoxEntity.getUpdatedAt(),
                currencyMultiBoxEntity.getCurrencyBox(),
                currencyMultiBoxEntity.getOperationId(),
                currencyMultiBoxEntity.getQuantity(),
                currencyMultiBoxEntity.getPriceOperation(),
                currencyMultiBoxEntity.getMultiBoxStatus());
    }

    @Override
    public List<CurrencyMultiBox> toCurrencyMultiBoxesModel(List<CurrencyMultiBoxEntity> currencyMultiBoxEntities) {
        return currencyMultiBoxEntities.stream()
                .map(this::toCurrencyMultiBoxModel)
                .toList();
    }

    @Override
    public CurrencyMultiBoxEntity toCurrencyMultiBoxEntity(CurrencyMultiBox currencyMultiBox) {
        return new CurrencyMultiBoxEntity(
                currencyMultiBox.getId(),
                currencyMultiBox.getUpdatedAt(),
                currencyMultiBox.getCurrencyBox(),
                currencyMultiBox.getOperationId(),
                currencyMultiBox.getQuantity(),
                currencyMultiBox.getPriceOperation(),
                currencyMultiBox.getMultiBoxStatus());
    }

    @Override
    public List<CurrencyMultiBoxEntity> toCurrencyMultiBoxesEntity(List<CurrencyMultiBox> currencyMultiBoxes) {
        return currencyMultiBoxes.stream()
                .map(this::toCurrencyMultiBoxEntity)
                .toList();
    }
}
