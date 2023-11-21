package dev.julioperez.littleTree.box.currencyBox.shared.application.returnQuantityOnCurrencyBoxByCancelledSellOperation.service;

import dev.julioperez.littleTree.box.currencyBox.foreignExchange.domain.port.recordForeignExchangeBoxToReturnEgress.RecordForeignExchangeBoxToReturnEgress;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.getCurrencyMultibox.GetCurrencyMultibox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.returnQuantityOnCurrencyBoxByCancelledSellOperation.ReturnQuantityOnCurrencyBoxByCancelledSellOperation;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.updateCurrenciesMultiboxBoxes.UpdateCurrenciesMultiboxBoxes;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;

import java.util.List;

public class ReturnQuantityOnCurrencyBoxByCancelledSellOperationService implements ReturnQuantityOnCurrencyBoxByCancelledSellOperation {
    private final GetCurrencyMultibox getCurrencyMultibox;
    private final UpdateCurrenciesMultiboxBoxes updateCurrenciesMultiboxBoxes;
    private final RecordForeignExchangeBoxToReturnEgress recordForeignExchangeBoxToReturnEgress;

    public ReturnQuantityOnCurrencyBoxByCancelledSellOperationService(GetCurrencyMultibox getCurrencyMultibox, UpdateCurrenciesMultiboxBoxes updateCurrenciesMultiboxBoxes, RecordForeignExchangeBoxToReturnEgress recordForeignExchangeBoxToReturnEgress) {
        this.getCurrencyMultibox = getCurrencyMultibox;
        this.updateCurrenciesMultiboxBoxes = updateCurrenciesMultiboxBoxes;
        this.recordForeignExchangeBoxToReturnEgress = recordForeignExchangeBoxToReturnEgress;
    }

    @Override
    public boolean execute(SellOperation sellOperation) {
        List<CurrencyMultiBox> currenciesMultiboxByOperationId = getCurrencyMultibox.getCurrenciesMultiboxByOperationId(sellOperation.getId());
        CurrencyMultiBox foreignCurrencyBox = getCurrencyBoxByValues(sellOperation.getCurrencyMultiBox(), currenciesMultiboxByOperationId);
        Float actualQuantityByExchangeCurrencyBox = getActualQuantityOfCurrencyBoxByDescription(foreignCurrencyBox.getCurrencyBox());
        CurrencyMultiBox foreignCurrencyBoxToReturnEgress = recordForeignExchangeBoxToReturnEgress.execute(foreignCurrencyBox, sellOperation, actualQuantityByExchangeCurrencyBox);
        //todo: question, what happen if quantity of box is less of 0?
        if(foreignCurrencyBoxToReturnEgress.getQuantity() < 0) throw new IllegalArgumentException(String.format("Quantity of box %s cant be less of zero", foreignCurrencyBoxToReturnEgress.getCurrencyBox()));
        List<CurrencyMultiBox> multiBoxesUpdated = updateCurrenciesMultiboxBoxes.execute(List.of(foreignCurrencyBoxToReturnEgress));
        return multiBoxesUpdated.size() == 1;
    }
    private CurrencyMultiBox getCurrencyBoxByValues(String currencyBox, List<CurrencyMultiBox> currenciesMultiboxToUpdate){
        List<CurrencyMultiBox> currencyMultiBoxes = currenciesMultiboxToUpdate.stream().filter(particular -> currencyBox.equals(particular.getCurrencyBox())).toList();
        if(currencyMultiBoxes.size() != 1) throw new IllegalArgumentException(String.format("list should has a size of 1, but return a size of %s , should return same quantity",currencyMultiBoxes.size()));
        return currencyMultiBoxes.get(0);
    }

    private Float getActualQuantityOfCurrencyBoxByDescription(String currencyBoxDescription){
        CurrencyBox currencyBox = CurrencyBox.returnCurrencyBoxByDescription(currencyBoxDescription);
        return getActualQuantityOfCurrencyBoxCaller(currencyBox);
    }
    private Float getActualQuantityOfCurrencyBoxCaller(CurrencyBox currencyBox){
        return getCurrencyMultibox
                .getLastCurrencyMultiboxByCurrencyBox(currencyBox)
                .getQuantity();
    }
}
