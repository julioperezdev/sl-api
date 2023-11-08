package dev.julioperez.littleTree.box.currencyBox.shared.domain.port.updateCurrencyMultiBox;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;

import java.util.List;

public interface UpdateCurrencyMultiBoxOutputPort {
    List<CurrencyMultiBox> currencyMultiBoxes(List<CurrencyMultiBox> currencyMultiBoxes);
    List<CurrencyMultiBox> getCurrenciesMultiboxByValues(List<String> currencyMultiBoxValues);
    List<CurrencyMultiBox> getCurrenciesMultiboxByOperationId(String operationId);
    CurrencyMultiBox getActualQuantityByCurrencyBox(CurrencyBox currencyBox);
    List<CurrencyMultiBox> saveCurrencyMultiBox(List<CurrencyMultiBox> newCurrenciesMultiBoxes);
}
