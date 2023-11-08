package dev.julioperez.littleTree.box.currencyBox.shared.domain.port.getCurrencyMultibox;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;

import java.util.List;

public interface GetCurrencyMultiboxOutputPort {
    List<CurrencyMultiBox> getCurrencyMultiboxByName(String name);
    CurrencyMultiBox getLastCurrencyMultiboxByCurrencyBox(CurrencyBox currencyBox);
}
