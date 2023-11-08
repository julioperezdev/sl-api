package dev.julioperez.littleTree.box.currencyBox.shared.domain.port.getCurrencyMultibox;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.dto.CurrencyMultiboxToList;

import java.util.List;

public interface GetCurrencyMultiboxInputPort {
    List<CurrencyMultiboxToList> getCurrencyMultiboxToListByName(String name);
}
