package dev.julioperez.littleTree.box.currencyBox.shared.application.updateCurrenciesMultiboxBoxes.service;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.updateCurrenciesMultiboxBoxes.UpdateCurrenciesMultiboxBoxes;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.updateCurrenciesMultiboxBoxes.UpdateCurrenciesMultiboxBoxesOutputPort;

import java.util.List;

public class UpdateCurrenciesMultiboxBoxesService implements UpdateCurrenciesMultiboxBoxes {
    private final UpdateCurrenciesMultiboxBoxesOutputPort updateCurrenciesMultiboxBoxesOutputPort;

    public UpdateCurrenciesMultiboxBoxesService(UpdateCurrenciesMultiboxBoxesOutputPort updateCurrenciesMultiboxBoxesOutputPort) {
        this.updateCurrenciesMultiboxBoxesOutputPort = updateCurrenciesMultiboxBoxesOutputPort;
    }

    @Override
    public List<CurrencyMultiBox> execute(List<CurrencyMultiBox> newCurrenciesMultiBoxes) {
        return updateCurrenciesMultiboxBoxesOutputPort.saveCurrencyMultiBox(newCurrenciesMultiBoxes);
    }
}
