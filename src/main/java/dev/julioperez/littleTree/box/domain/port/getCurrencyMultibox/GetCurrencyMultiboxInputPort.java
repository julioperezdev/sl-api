package dev.julioperez.littleTree.box.domain.port.getCurrencyMultibox;

import dev.julioperez.littleTree.box.domain.dto.CurrencyMultiboxToList;

import java.util.List;

public interface GetCurrencyMultiboxInputPort {
    List<CurrencyMultiboxToList> getCurrencyMultiboxToListByName(String name);
}
