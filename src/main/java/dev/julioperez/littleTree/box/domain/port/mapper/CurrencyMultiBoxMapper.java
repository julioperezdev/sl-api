package dev.julioperez.littleTree.box.domain.port.mapper;

import dev.julioperez.littleTree.box.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.infrastructure.repository.entity.CurrencyMultiBoxEntity;
import dev.julioperez.littleTree.client.domain.dto.CreateClientDifferenceRequest;
import dev.julioperez.littleTree.client.domain.dto.UpdateClientDifferenceRequest;
import dev.julioperez.littleTree.client.domain.model.ClientDifference;
import dev.julioperez.littleTree.client.infrastructure.repository.entity.ClientDifferenceEntity;

import java.util.List;

public interface CurrencyMultiBoxMapper {
    //CurrencyMultiBox toCurrencyMultiBoxModel(UpdateCurrencyMultiBoxRequest updateCurrencyMultiBoxRequest);
    CurrencyMultiBox toCurrencyMultiBoxModel(CurrencyMultiBoxEntity currencyMultiBoxEntity);
    List<CurrencyMultiBox> toCurrencyMultiBoxesModel(List<CurrencyMultiBoxEntity> currencyMultiBoxEntities);
    CurrencyMultiBoxEntity toCurrencyMultiBoxEntity(CurrencyMultiBox currencyMultiBox);
    List<CurrencyMultiBoxEntity> toCurrencyMultiBoxesEntity(List<CurrencyMultiBox> currencyMultiBoxes);
}
