package dev.julioperez.littleTree.currency.domain.port.updateCurrency;

import dev.julioperez.littleTree.currency.domain.dto.UpdateCurrencyRequest;
import dev.julioperez.littleTree.currency.domain.model.Currency;

import java.util.List;

public interface UpdateCurrencyInputPort {
    List<Currency> updateCurrency(UpdateCurrencyRequest updateCurrencyRequest);
}
