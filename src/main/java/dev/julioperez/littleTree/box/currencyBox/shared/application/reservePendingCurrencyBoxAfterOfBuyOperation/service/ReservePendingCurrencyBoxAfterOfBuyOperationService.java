package dev.julioperez.littleTree.box.currencyBox.shared.application.reservePendingCurrencyBoxAfterOfBuyOperation.service;

import dev.julioperez.littleTree.box.currencyBox.foreignExchange.domain.port.recordPendingForeignExchangeToIngress.RecordPendingForeignExchangeToIngress;
import dev.julioperez.littleTree.box.currencyBox.officeDebt.domain.port.recordPendingOfficeBoxToEgress.RecordPendingOfficeBoxToEgress;
import dev.julioperez.littleTree.box.currencyBox.pesos.domain.port.recordPendingPesosBoxToEgress.RecordPendingPesosBoxToEgress;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.getCurrencyMultibox.GetCurrencyMultibox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.reservePendingCurrencyBoxAfterOfBuyOperation.ReservePendingCurrencyBoxAfterOfBuyOperation;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.updateCurrenciesMultiboxBoxes.UpdateCurrenciesMultiboxBoxes;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;

import java.util.List;

public class ReservePendingCurrencyBoxAfterOfBuyOperationService implements ReservePendingCurrencyBoxAfterOfBuyOperation {
    private final GetCurrencyMultibox getCurrencyMultibox;
    private final UpdateCurrenciesMultiboxBoxes updateCurrenciesMultiboxBoxes;
    private final RecordPendingForeignExchangeToIngress recordPendingForeignExchangeToIngress;
    private final RecordPendingOfficeBoxToEgress recordPendingOfficeBoxToEgress;
    private final RecordPendingPesosBoxToEgress recordPendingPesosBoxToEgress;

    public ReservePendingCurrencyBoxAfterOfBuyOperationService(GetCurrencyMultibox getCurrencyMultibox, UpdateCurrenciesMultiboxBoxes updateCurrenciesMultiboxBoxes, RecordPendingForeignExchangeToIngress recordPendingForeignExchangeToIngress, RecordPendingOfficeBoxToEgress recordPendingOfficeBoxToEgress, RecordPendingPesosBoxToEgress recordPendingPesosBoxToEgress) {
        this.getCurrencyMultibox = getCurrencyMultibox;
        this.updateCurrenciesMultiboxBoxes = updateCurrenciesMultiboxBoxes;
        this.recordPendingForeignExchangeToIngress = recordPendingForeignExchangeToIngress;
        this.recordPendingOfficeBoxToEgress = recordPendingOfficeBoxToEgress;
        this.recordPendingPesosBoxToEgress = recordPendingPesosBoxToEgress;
    }

    @Override
    public boolean execute(List<BuyOperation> buyOperations) {
        List<Boolean> allResults = buyOperations.stream().map(this::reserveParticularPendingCurrencyBoxAfterOfBuyOperation).toList();
        return allResults.stream().allMatch(particularResult -> particularResult.equals(true));
    }

    private boolean reserveParticularPendingCurrencyBoxAfterOfBuyOperation(BuyOperation buyOperation){
        List<String> boxToUse = buyOperation.hasOfficeCheck()
                ? List.of(CurrencyBox.PESO_OFFICE.value(), buyOperation.getCurrencyMultiBox())
                : List.of(CurrencyBox.PESO.value(), buyOperation.getCurrencyMultiBox());
        List<CurrencyMultiBox> currenciesMultiboxToUpdate = getCurrencyMultibox.getCurrenciesMultiboxByValues(boxToUse);
        if(boxToUse.size() != currenciesMultiboxToUpdate.size()) throw new IllegalArgumentException(String.format("list should has a size of %s, but return a size of %s , should return same quantity",boxToUse.size(), currenciesMultiboxToUpdate.size()));
        return instanceIngressAndEgressToSaveToBuyOperation(currenciesMultiboxToUpdate, buyOperation);
    }

    private boolean instanceIngressAndEgressToSaveToBuyOperation(List<CurrencyMultiBox> currenciesMultiboxToUpdate, BuyOperation buyOperation){
        CurrencyMultiBox foreignExchangeBox = getCurrencyBoxByValues(buyOperation.getCurrencyMultiBox(), currenciesMultiboxToUpdate);
        String egressBox = buyOperation.hasOfficeCheck() ? CurrencyBox.PESO_OFFICE.value() : CurrencyBox.PESO.value();
        CurrencyMultiBox pesosOrOfficeBox = getCurrencyBoxByValues(egressBox, currenciesMultiboxToUpdate);

        CurrencyMultiBox foreignExchangeToIngress = recordPendingForeignExchangeToIngress.execute(foreignExchangeBox, buyOperation);
        CurrencyMultiBox pesosOrOfficeBoxToEgress = buyOperation.hasOfficeCheck()
                ? recordPendingOfficeBoxToEgress.execute(pesosOrOfficeBox, buyOperation)
                : recordPendingPesosBoxToEgress.execute(pesosOrOfficeBox, buyOperation);

        if(pesosOrOfficeBoxToEgress.getQuantity() < 0) throw new IllegalArgumentException(String.format("Quantity of box %s cant be less of zero", pesosOrOfficeBox.getCurrencyBox()));
        List<CurrencyMultiBox> multiBoxesUpdated = updateCurrenciesMultiboxBoxes.execute(List.of(foreignExchangeToIngress, pesosOrOfficeBoxToEgress));
        return multiBoxesUpdated.size() == 2;
    }

    private CurrencyMultiBox getCurrencyBoxByValues(String currencyBox, List<CurrencyMultiBox> currenciesMultiboxToUpdate){
        List<CurrencyMultiBox> currencyMultiBoxes = currenciesMultiboxToUpdate.stream().filter(particular -> currencyBox.equals(particular.getCurrencyBox())).toList();
        if(currencyMultiBoxes.size() != 1) throw new IllegalArgumentException(String.format("list should has a size of 1, but return a size of %s , should return same quantity",currencyMultiBoxes.size()));
        return currencyMultiBoxes.get(0);
    }
}
