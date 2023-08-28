package dev.julioperez.littleTree.box.domain.port.updateCurrencyMultiBox;

import dev.julioperez.littleTree.box.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.box.domain.model.CurrencyMultiBox;

import java.util.List;

public interface UpdateCurrencyMultiBoxOutputPort {
    List<CurrencyMultiBox> currencyMultiBoxes(List<CurrencyMultiBox> currencyMultiBoxes);
    List<CurrencyMultiBox> getCurrenciesMultiboxByValues(List<String> currencyMultiBoxValues);
    List<CurrencyMultiBox> getCurrenciesMultiboxByOperationId(String operationId);
    CurrencyMultiBox getActualQuantityByCurrencyBox(CurrencyBox currencyBox);
}
