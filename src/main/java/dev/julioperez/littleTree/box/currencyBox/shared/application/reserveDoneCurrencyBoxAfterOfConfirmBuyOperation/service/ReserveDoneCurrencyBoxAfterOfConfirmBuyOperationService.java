package dev.julioperez.littleTree.box.currencyBox.shared.application.reserveDoneCurrencyBoxAfterOfConfirmBuyOperation.service;

import dev.julioperez.littleTree.box.currencyBox.foreignExchange.domain.port.recordForeignExchangeToConfirmIngress.RecordForeignExchangeToConfirmIngress;
import dev.julioperez.littleTree.box.currencyBox.officeDebt.domain.port.recordOfficeBoxToConfirmEgress.RecordOfficeBoxToConfirmEgress;
import dev.julioperez.littleTree.box.currencyBox.pesos.domain.port.recordPesosBoxToConfirmEgress.RecordPesosBoxToConfirmEgress;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.dto.LastQuantityAndQuantityViewed;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.getCurrencyMultibox.GetCurrencyMultibox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.reserveDoneCurrencyBoxAfterOfConfirmBuyOperation.ReserveDoneCurrencyBoxAfterOfConfirmBuyOperation;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.updateCurrenciesMultiboxBoxes.UpdateCurrenciesMultiboxBoxes;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;

import java.util.List;

public class ReserveDoneCurrencyBoxAfterOfConfirmBuyOperationService implements ReserveDoneCurrencyBoxAfterOfConfirmBuyOperation {
    private final GetCurrencyMultibox getCurrencyMultibox;
    private final UpdateCurrenciesMultiboxBoxes updateCurrenciesMultiboxBoxes;
    private final RecordForeignExchangeToConfirmIngress recordForeignExchangeToConfirmIngress;
    private final RecordOfficeBoxToConfirmEgress recordOfficeBoxToConfirmEgress;
    private final RecordPesosBoxToConfirmEgress recordPesosBoxToConfirmEgress;

    public ReserveDoneCurrencyBoxAfterOfConfirmBuyOperationService(GetCurrencyMultibox getCurrencyMultibox, UpdateCurrenciesMultiboxBoxes updateCurrenciesMultiboxBoxes, RecordForeignExchangeToConfirmIngress recordForeignExchangeToConfirmIngress, RecordOfficeBoxToConfirmEgress recordOfficeBoxToConfirmEgress, RecordPesosBoxToConfirmEgress recordPesosBoxToConfirmEgress) {
        this.getCurrencyMultibox = getCurrencyMultibox;
        this.updateCurrenciesMultiboxBoxes = updateCurrenciesMultiboxBoxes;
        this.recordForeignExchangeToConfirmIngress = recordForeignExchangeToConfirmIngress;
        this.recordOfficeBoxToConfirmEgress = recordOfficeBoxToConfirmEgress;
        this.recordPesosBoxToConfirmEgress = recordPesosBoxToConfirmEgress;
    }

    @Override
    public boolean execute(BuyOperation buyOperation) {
        List<CurrencyMultiBox> currenciesMultiboxByOperationId = getCurrencyMultibox.getCurrenciesMultiboxByOperationId(buyOperation.getId());
        CurrencyMultiBox foreignCurrencyBox = getCurrencyBoxByValues(buyOperation.getCurrencyMultiBox(), currenciesMultiboxByOperationId);
        String egressBox = buyOperation.hasOfficeCheck() ? CurrencyBox.PESO_OFFICE.value() : CurrencyBox.PESO.value();
        CurrencyMultiBox pesosOrOfficeBox = getCurrencyBoxByValues(egressBox, currenciesMultiboxByOperationId);

        LastQuantityAndQuantityViewed actualQuantityAndQuantityViewedByForeignExchangeBox = getLastQuantityAndQuantityViewedOfCurrencyBoxByDescription(foreignCurrencyBox.getCurrencyBox());
        LastQuantityAndQuantityViewed actualQuantityAndQuantityViewedByPesosOrOfficeBox = getLastQuantityAndQuantityViewedOfCurrencyBoxByDescription(egressBox);

        CurrencyMultiBox foreignExchangeToIngress = recordForeignExchangeToConfirmIngress.execute(foreignCurrencyBox, buyOperation, actualQuantityAndQuantityViewedByForeignExchangeBox);
        CurrencyMultiBox pesosOrOfficeBoxToEgress =
                buyOperation.hasOfficeCheck()
                        ? recordOfficeBoxToConfirmEgress.execute(pesosOrOfficeBox, buyOperation,actualQuantityAndQuantityViewedByPesosOrOfficeBox)
                        : recordPesosBoxToConfirmEgress.execute(pesosOrOfficeBox, buyOperation,actualQuantityAndQuantityViewedByPesosOrOfficeBox);

        //todo: question, what happen if quantity of box is less of 0?
        if(pesosOrOfficeBoxToEgress.getQuantity() < 0) throw new IllegalArgumentException(String.format("Quantity of box %s cant be less of zero", pesosOrOfficeBox.getCurrencyBox()));
        List<CurrencyMultiBox> multiBoxesUpdated = updateCurrenciesMultiboxBoxes.execute(List.of(foreignExchangeToIngress, pesosOrOfficeBoxToEgress));
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
