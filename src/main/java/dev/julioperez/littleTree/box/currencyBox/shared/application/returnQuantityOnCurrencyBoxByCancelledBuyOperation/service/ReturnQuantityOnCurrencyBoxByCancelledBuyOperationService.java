package dev.julioperez.littleTree.box.currencyBox.shared.application.returnQuantityOnCurrencyBoxByCancelledBuyOperation.service;

import dev.julioperez.littleTree.box.currencyBox.officeDebt.domain.port.recordOfficeBoxToReturnEgress.RecordOfficeBoxToReturnEgress;
import dev.julioperez.littleTree.box.currencyBox.pesos.domain.port.recordPesosBoxToReturnEgress.RecordPesosBoxToReturnEgress;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.getCurrencyMultibox.GetCurrencyMultibox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.returnQuantityOnCurrencyBoxByCancelledBuyOperation.ReturnQuantityOnCurrencyBoxByCancelledBuyOperation;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.updateCurrenciesMultiboxBoxes.UpdateCurrenciesMultiboxBoxes;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;

import java.util.List;

public class ReturnQuantityOnCurrencyBoxByCancelledBuyOperationService implements ReturnQuantityOnCurrencyBoxByCancelledBuyOperation {
    private final GetCurrencyMultibox getCurrencyMultibox;
    private final UpdateCurrenciesMultiboxBoxes updateCurrenciesMultiboxBoxes;
    private final RecordOfficeBoxToReturnEgress recordOfficeBoxToReturnEgress;
    private final RecordPesosBoxToReturnEgress recordPesosBoxToReturnEgress;

    public ReturnQuantityOnCurrencyBoxByCancelledBuyOperationService(GetCurrencyMultibox getCurrencyMultibox, UpdateCurrenciesMultiboxBoxes updateCurrenciesMultiboxBoxes, RecordOfficeBoxToReturnEgress recordOfficeBoxToReturnEgress, RecordPesosBoxToReturnEgress recordPesosBoxToReturnEgress) {
        this.getCurrencyMultibox = getCurrencyMultibox;
        this.updateCurrenciesMultiboxBoxes = updateCurrenciesMultiboxBoxes;
        this.recordOfficeBoxToReturnEgress = recordOfficeBoxToReturnEgress;
        this.recordPesosBoxToReturnEgress = recordPesosBoxToReturnEgress;
    }

    @Override
    public boolean execute(BuyOperation buyOperation) {
        List<CurrencyMultiBox> currenciesMultiboxByOperationId = getCurrencyMultibox.getCurrenciesMultiboxByOperationId(buyOperation.getId());
        String egressBox = buyOperation.hasOfficeCheck() ? CurrencyBox.PESO_OFFICE.value() : CurrencyBox.PESO.value();
        CurrencyMultiBox pesosOrOfficeBox = getCurrencyBoxByValues(egressBox, currenciesMultiboxByOperationId);
        Float actualQuantityByPesosOrOfficeBox = getActualQuantityOfCurrencyBoxByDescription(egressBox);

        CurrencyMultiBox pesosOrOfficeBoxToReturnEgress =
                buyOperation.hasOfficeCheck()
                        ? recordOfficeBoxToReturnEgress.execute(pesosOrOfficeBox, buyOperation, actualQuantityByPesosOrOfficeBox)
                        : recordPesosBoxToReturnEgress.execute(pesosOrOfficeBox, buyOperation, actualQuantityByPesosOrOfficeBox);

        //todo: question, what happen if quantity of box is less of 0?
        if(pesosOrOfficeBoxToReturnEgress.getQuantity() < 0) throw new IllegalArgumentException(String.format("Quantity of box %s cant be less of zero", pesosOrOfficeBoxToReturnEgress.getCurrencyBox()));
        List<CurrencyMultiBox> multiBoxesUpdated = updateCurrenciesMultiboxBoxes.execute(List.of(pesosOrOfficeBoxToReturnEgress));
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
