package dev.julioperez.littleTree.box.currencyBox.shared.application.reservePendingCurrencyBoxAfterOfSellOperation.service;

import dev.julioperez.littleTree.box.currencyBox.foreignExchange.domain.port.recordPendingForeignExchangeToEgress.RecordPendingForeignExchangeToEgress;
import dev.julioperez.littleTree.box.currencyBox.pesos.domain.port.recordPendingPesosBoxToIngress.RecordPendingPesosBoxToIngress;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.getCurrencyMultibox.GetCurrencyMultibox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.reservePendingCurrencyBoxAfterOfSellOperation.ReservePendingCurrencyBoxAfterOfSellOperation;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.updateCurrenciesMultiboxBoxes.UpdateCurrenciesMultiboxBoxes;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;

import java.util.List;

public class ReservePendingCurrencyBoxAfterOfSellOperationService implements ReservePendingCurrencyBoxAfterOfSellOperation {
    private final GetCurrencyMultibox getCurrencyMultibox;
    private final UpdateCurrenciesMultiboxBoxes updateCurrenciesMultiboxBoxes;
    private final RecordPendingForeignExchangeToEgress recordPendingForeignExchangeToEgress;
    private final RecordPendingPesosBoxToIngress recordPendingPesosBoxToIngress;

    public ReservePendingCurrencyBoxAfterOfSellOperationService(GetCurrencyMultibox getCurrencyMultibox, UpdateCurrenciesMultiboxBoxes updateCurrenciesMultiboxBoxes, RecordPendingForeignExchangeToEgress recordPendingForeignExchangeToEgress, RecordPendingPesosBoxToIngress recordPendingPesosBoxToIngress) {
        this.getCurrencyMultibox = getCurrencyMultibox;
        this.updateCurrenciesMultiboxBoxes = updateCurrenciesMultiboxBoxes;
        this.recordPendingForeignExchangeToEgress = recordPendingForeignExchangeToEgress;
        this.recordPendingPesosBoxToIngress = recordPendingPesosBoxToIngress;
    }

    @Override
    public boolean execute(List<SellOperation> sellOperations) {
        List<Boolean> allResults = sellOperations.stream().map(this::reserveParticularPendingCurrencyBoxAfterOfSellOperation).toList();
        return allResults.stream().allMatch(particularResult -> particularResult.equals(true));
    }
    private boolean reserveParticularPendingCurrencyBoxAfterOfSellOperation(SellOperation sellOperation){
        List<String> currenciesValues = List.of(CurrencyBox.PESO.value(), sellOperation.getCurrencyMultiBox());
        List<CurrencyMultiBox> currenciesMultiboxToUpdate = getCurrencyMultibox.getCurrenciesMultiboxByValues(currenciesValues);
        if(currenciesValues.size() != currenciesMultiboxToUpdate.size()) throw new IllegalArgumentException(String.format("list should has a size of %s, but return a size of %s , should return same quantity",currenciesValues.size(), currenciesMultiboxToUpdate.size()));
        return instanceIngressAndEgressToSaveToSellOperation(currenciesMultiboxToUpdate, sellOperation);
    }

    private boolean instanceIngressAndEgressToSaveToSellOperation(List<CurrencyMultiBox> currenciesMultiboxToUpdate, SellOperation sellOperation){
        CurrencyMultiBox foreignExchangeBox = getCurrencyBoxByValues(sellOperation.getCurrencyMultiBox(), currenciesMultiboxToUpdate);
        CurrencyMultiBox pesosBox = getCurrencyBoxByValues(CurrencyBox.PESO.value(), currenciesMultiboxToUpdate);;


        CurrencyMultiBox foreignExchangeToEgress = recordPendingForeignExchangeToEgress.execute(foreignExchangeBox, sellOperation);
        CurrencyMultiBox pesosOrOfficeBoxToIngress = recordPendingPesosBoxToIngress.execute(pesosBox, sellOperation);

        //todo: question, what happen if quantity of box is less of 0?
        if(foreignExchangeToEgress.getQuantity() < 0) throw new IllegalArgumentException(String.format("Quantity of box %s cant be less of zero", foreignExchangeToEgress.getCurrencyBox()));
        List<CurrencyMultiBox> multiBoxesUpdated = updateCurrenciesMultiboxBoxes.execute(List.of(foreignExchangeToEgress, pesosOrOfficeBoxToIngress));
        return multiBoxesUpdated.size() == 2;
    }

    private CurrencyMultiBox getCurrencyBoxByValues(String currencyBox, List<CurrencyMultiBox> currenciesMultiboxToUpdate){
        List<CurrencyMultiBox> currencyMultiBoxes = currenciesMultiboxToUpdate.stream().filter(particular -> currencyBox.equals(particular.getCurrencyBox())).toList();
        if(currencyMultiBoxes.size() != 1) throw new IllegalArgumentException(String.format("list should has a size of 1, but return a size of %s , should return same quantity",currencyMultiBoxes.size()));
        return currencyMultiBoxes.get(0);
    }
}
