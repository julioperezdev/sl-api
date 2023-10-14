package dev.julioperez.littleTree.box.application.getCurrencyMultibox.service;

import dev.julioperez.littleTree.box.domain.dto.CurrencyMultiboxToList;
import dev.julioperez.littleTree.box.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.domain.port.getCurrencyMultibox.GetCurrencyMultibox;
import dev.julioperez.littleTree.box.domain.port.getCurrencyMultibox.GetCurrencyMultiboxOutputPort;

import java.util.Comparator;
import java.util.List;
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
    private CurrencyMultiboxToList mapCurrencyMultiboxToList(CurrencyMultiBox currencyMultiBox){
        return new CurrencyMultiboxToList(
                currencyMultiBox.getId(),
                currencyMultiBox.getUpdatedAt(),
                currencyMultiBox.getOperationType(),
                currencyMultiBox.getQuantityOperation(),
                currencyMultiBox.getQuantity());
    }
}
