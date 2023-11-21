package dev.julioperez.littleTree.box.currencyBox.shared.domain.port.getCurrencyMultibox;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.dto.CurrencyMultiboxToList;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.MultiBoxStatus;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;

import java.util.List;

public interface GetCurrencyMultibox {
    List<CurrencyMultiboxToList> getCurrencyMultiboxToListByName(String name);
    CurrencyMultiBox getLastCurrencyMultiboxByCurrencyBox(CurrencyBox currencyBox);
    Float getTotalByCurrencyBox(CurrencyBox currencyBox);
    Float getTotalByCurrencyBoxByDoneOrCancelledMultiBoxStatus(CurrencyBox currencyBox);
    List<CurrencyMultiBox> getCurrenciesMultiboxByOperationId(String operationId);
    List<CurrencyMultiBox> getCurrenciesMultiboxByValues(List<String> currencyMultiBoxValues);
}
