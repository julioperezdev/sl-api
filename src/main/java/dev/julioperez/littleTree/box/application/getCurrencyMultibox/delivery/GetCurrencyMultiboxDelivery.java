package dev.julioperez.littleTree.box.application.getCurrencyMultibox.delivery;

import dev.julioperez.littleTree.box.domain.dto.CurrencyMultiboxToList;
import dev.julioperez.littleTree.box.domain.port.getCurrencyMultibox.GetCurrencyMultibox;
import dev.julioperez.littleTree.box.domain.port.getCurrencyMultibox.GetCurrencyMultiboxInputPort;

import java.util.List;

public class GetCurrencyMultiboxDelivery implements GetCurrencyMultiboxInputPort {
    private final GetCurrencyMultibox getCurrencyMultibox;

    public GetCurrencyMultiboxDelivery(GetCurrencyMultibox getCurrencyMultibox) {
        this.getCurrencyMultibox = getCurrencyMultibox;
    }
    @Override
    public List<CurrencyMultiboxToList> getCurrencyMultiboxToListByName(String name) {
        return getCurrencyMultibox.getCurrencyMultiboxToListByName(name);
    }
}
