package dev.julioperez.littleTree.box.currencyBox.shared.domain.port.updateCurrenciesMultiboxBoxes;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;

import java.util.List;

public interface UpdateCurrenciesMultiboxBoxes {
    List<CurrencyMultiBox> execute(List<CurrencyMultiBox> newCurrenciesMultiBoxes);
}
