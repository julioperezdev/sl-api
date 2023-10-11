package dev.julioperez.littleTree.box.domain.port.getCurrencyMultibox;

import dev.julioperez.littleTree.box.domain.dto.CurrencyMultiboxToList;
import dev.julioperez.littleTree.box.domain.model.CurrencyMultiBox;

import java.util.List;

public interface GetCurrencyMultiboxOutputPort {
    List<CurrencyMultiBox> getCurrencyMultiboxByName(String name);
}
