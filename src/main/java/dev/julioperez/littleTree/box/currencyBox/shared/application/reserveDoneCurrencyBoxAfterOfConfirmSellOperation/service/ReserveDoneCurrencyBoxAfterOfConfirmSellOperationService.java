package dev.julioperez.littleTree.box.currencyBox.shared.application.reserveDoneCurrencyBoxAfterOfConfirmSellOperation.service;

import dev.julioperez.littleTree.box.currencyBox.foreignExchange.domain.port.recordForeignExchangeToConfirmEgress.RecordForeignExchangeToConfirmEgress;
import dev.julioperez.littleTree.box.currencyBox.pesos.domain.port.recordPesosBoxToConfirmIngress.RecordPesosBoxToConfirmIngress;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.dto.LastQuantityAndQuantityViewed;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.getCurrencyMultibox.GetCurrencyMultibox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.reserveDoneCurrencyBoxAfterOfConfirmSellOperation.ReserveDoneCurrencyBoxAfterOfConfirmSellOperation;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.updateCurrenciesMultiboxBoxes.UpdateCurrenciesMultiboxBoxes;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;

import java.util.List;

public class ReserveDoneCurrencyBoxAfterOfConfirmSellOperationService implements ReserveDoneCurrencyBoxAfterOfConfirmSellOperation {
    private final GetCurrencyMultibox getCurrencyMultibox;
    private final UpdateCurrenciesMultiboxBoxes updateCurrenciesMultiboxBoxes;
    private final RecordForeignExchangeToConfirmEgress recordForeignExchangeToConfirmEgress;
    private final RecordPesosBoxToConfirmIngress recordPesosBoxToConfirmIngress;

    public ReserveDoneCurrencyBoxAfterOfConfirmSellOperationService(GetCurrencyMultibox getCurrencyMultibox, UpdateCurrenciesMultiboxBoxes updateCurrenciesMultiboxBoxes, RecordForeignExchangeToConfirmEgress recordForeignExchangeToConfirmEgress, RecordPesosBoxToConfirmIngress recordPesosBoxToConfirmIngress) {
        this.getCurrencyMultibox = getCurrencyMultibox;
        this.updateCurrenciesMultiboxBoxes = updateCurrenciesMultiboxBoxes;
        this.recordForeignExchangeToConfirmEgress = recordForeignExchangeToConfirmEgress;
        this.recordPesosBoxToConfirmIngress = recordPesosBoxToConfirmIngress;
    }


    @Override
    public boolean execute(SellOperation sellOperation) {
        List<CurrencyMultiBox> currenciesMultiboxByOperationId = getCurrencyMultibox.getCurrenciesMultiboxByOperationId(sellOperation.getId());
        CurrencyMultiBox foreignCurrencyBox = getCurrencyBoxByValues(sellOperation.getCurrencyMultiBox(), currenciesMultiboxByOperationId);
        CurrencyMultiBox pesosBox = getCurrencyBoxByValues(CurrencyBox.PESO.value(), currenciesMultiboxByOperationId);

        LastQuantityAndQuantityViewed actualQuantityAndQuantityViewedByForeignExchangeBox = getLastQuantityAndQuantityViewedOfCurrencyBoxByDescription(foreignCurrencyBox.getCurrencyBox());
        LastQuantityAndQuantityViewed actualQuantityAndQuantityViewedByPesosBox = getLastQuantityAndQuantityViewedOfCurrencyBoxByDescription(pesosBox.getCurrencyBox());

        CurrencyMultiBox foreignExchangeToEgress = recordForeignExchangeToConfirmEgress.execute(foreignCurrencyBox, sellOperation, actualQuantityAndQuantityViewedByForeignExchangeBox);
        CurrencyMultiBox pesosBoxToIngress = recordPesosBoxToConfirmIngress.execute(pesosBox, sellOperation, actualQuantityAndQuantityViewedByPesosBox);

        //todo: question, what happen if quantity of box is less of 0?
        //if(foreignExchangeToEgress.getQuantity() < 0) throw new IllegalArgumentException(String.format("Quantity of box %s cant be less of zero", foreignExchangeToEgress.getCurrencyBox()));
        List<CurrencyMultiBox> multiBoxesUpdated = updateCurrenciesMultiboxBoxes.execute(List.of(foreignExchangeToEgress, pesosBoxToIngress));
        return multiBoxesUpdated.size() == 2;
    }
    private CurrencyMultiBox getCurrencyBoxByValues(String currencyBox, List<CurrencyMultiBox> currenciesMultiboxToUpdate){
        List<CurrencyMultiBox> currencyMultiBoxes = currenciesMultiboxToUpdate.stream().filter(particular -> currencyBox.equals(particular.getCurrencyBox())).toList();
        if(currencyMultiBoxes.size() != 1) throw new IllegalArgumentException(String.format("list should has a size of 1, but return a size of %s , should return same quantity",currencyMultiBoxes.size()));
        return currencyMultiBoxes.get(0);
    }

    private LastQuantityAndQuantityViewed getLastQuantityAndQuantityViewedOfCurrencyBoxByDescription(String currencyBoxDescription){
        CurrencyBox currencyBox = CurrencyBox.returnCurrencyBoxByDescription(currencyBoxDescription);
        CurrencyMultiBox actualQuantityOfCurrencyBoxCaller = getActualQuantityOfCurrencyBoxCaller(currencyBox);
        return new LastQuantityAndQuantityViewed(
                actualQuantityOfCurrencyBoxCaller.getQuantity(),
                actualQuantityOfCurrencyBoxCaller.getQuantityChanged());
    }

    private CurrencyMultiBox getActualQuantityOfCurrencyBoxCaller(CurrencyBox currencyBox){
        return getCurrencyMultibox
                .getLastCurrencyMultiboxByCurrencyBox(currencyBox);
    }
}
