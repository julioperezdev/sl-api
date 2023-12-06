package dev.julioperez.littleTree.box.currencyBox.shared.application.getCurrencyMultibox.delivery;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.dto.CurrencyMultiboxToList;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.getCurrencyMultibox.GetCurrencyMultibox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.getCurrencyMultibox.GetCurrencyMultiboxInputPort;

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

    @Override
    public Float getTotalByCurrencyBox(CurrencyBox currencyBox) {
        return getCurrencyMultibox.getTotalByCurrencyBox(currencyBox);
    }
}
