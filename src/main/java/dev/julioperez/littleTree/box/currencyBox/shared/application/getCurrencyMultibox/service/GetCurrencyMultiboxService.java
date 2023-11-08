package dev.julioperez.littleTree.box.currencyBox.shared.application.getCurrencyMultibox.service;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.dto.CurrencyMultiboxToList;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.getCurrencyMultibox.GetCurrencyMultibox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.getCurrencyMultibox.GetCurrencyMultiboxOutputPort;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GetCurrencyMultiboxService implements GetCurrencyMultibox {

    private final GetCurrencyMultiboxOutputPort getCurrencyMultiboxOutputPort;

    public GetCurrencyMultiboxService(GetCurrencyMultiboxOutputPort getCurrencyMultiboxOutputPort) {
        this.getCurrencyMultiboxOutputPort = getCurrencyMultiboxOutputPort;
    }

    @Override
    public List<CurrencyMultiboxToList> getCurrencyMultiboxToListByName(String name) {
        List<CurrencyMultiBox> currencyMultiboxByName = getCurrencyMultiboxOutputPort.getCurrencyMultiboxByName(name);
        return currencyMultiboxByName.stream().map(this::mapCurrencyMultiboxToList).sorted(Comparator.comparing(CurrencyMultiboxToList::updatedAt).reversed()).collect(Collectors.toList());
    }

    @Override
    public CurrencyMultiBox getLastCurrencyMultiboxByCurrencyBox(CurrencyBox currencyBox) {
        return getCurrencyMultiboxOutputPort.getLastCurrencyMultiboxByCurrencyBox(currencyBox);
    }

    @Override
    public Float getTotalByCurrencyBox(CurrencyBox currencyBox) {
        CurrencyMultiBox lastCurrencyMultiboxByCurrencyBox = getCurrencyMultiboxOutputPort.getLastCurrencyMultiboxByCurrencyBox(currencyBox);
        return Objects.isNull(lastCurrencyMultiboxByCurrencyBox)
                ? 0
                : lastCurrencyMultiboxByCurrencyBox.getQuantity();
    }

    private CurrencyMultiboxToList mapCurrencyMultiboxToList(CurrencyMultiBox currencyMultiBox){
        return new CurrencyMultiboxToList(
                currencyMultiBox.getId(),
                currencyMultiBox.getUpdatedAt(),
                currencyMultiBox.getOperationType(),
                currencyMultiBox.getQuantityOperation(),
                currencyMultiBox.getQuantity(),
                currencyMultiBox.getMultiBoxStatus());
    }
}
