package dev.julioperez.littleTree.box.currencyBox.shared.application.modelMapper;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.mapper.CurrencyMultiBoxMapper;
import dev.julioperez.littleTree.box.currencyBox.shared.infrastructure.repository.entity.CurrencyMultiBoxEntity;

import java.util.List;

public class CurrencyMultiBoxModelMapper implements CurrencyMultiBoxMapper {

    @Override
    public CurrencyMultiBox toCurrencyMultiBoxModel(CurrencyMultiBoxEntity currencyMultiBoxEntity) {
        return new CurrencyMultiBox(
                currencyMultiBoxEntity.getId(),
                currencyMultiBoxEntity.getUpdatedAt(),
                currencyMultiBoxEntity.getCurrencyBox(),
                currencyMultiBoxEntity.getOperationId(),
                currencyMultiBoxEntity.getOperationType(),
                currencyMultiBoxEntity.getQuantity(),
                currencyMultiBoxEntity.getQuantityOperation(),
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
                currencyMultiBox.getOperationType(),
                currencyMultiBox.getQuantity(),
                currencyMultiBox.getQuantityOperation(),
                currencyMultiBox.getMultiBoxStatus());
    }

    @Override
    public List<CurrencyMultiBoxEntity> toCurrencyMultiBoxesEntity(List<CurrencyMultiBox> currencyMultiBoxes) {
        return currencyMultiBoxes.stream()
                .map(this::toCurrencyMultiBoxEntity)
                .toList();
    }
}
