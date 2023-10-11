package dev.julioperez.littleTree.box.application.getCurrencyMultibox.service;

import dev.julioperez.littleTree.box.domain.dto.CurrencyMultiboxToList;
import dev.julioperez.littleTree.box.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.domain.port.getCurrencyMultibox.GetCurrencyMultibox;
import dev.julioperez.littleTree.box.domain.port.getCurrencyMultibox.GetCurrencyMultiboxOutputPort;

import java.util.List;

public class GetCurrencyMultiboxService implements GetCurrencyMultibox {

    private final GetCurrencyMultiboxOutputPort getCurrencyMultiboxOutputPort;

    public GetCurrencyMultiboxService(GetCurrencyMultiboxOutputPort getCurrencyMultiboxOutputPort) {
        this.getCurrencyMultiboxOutputPort = getCurrencyMultiboxOutputPort;
    }

    @Override
    public List<CurrencyMultiboxToList> getCurrencyMultiboxToListByName(String name) {
        List<CurrencyMultiBox> currencyMultiboxByName = getCurrencyMultiboxOutputPort.getCurrencyMultiboxByName(name);
        return currencyMultiboxByName.stream().map(this::mapCurrencyMultiboxToList).toList();
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
