package dev.julioperez.littleTree.box.currencyBox.shared.application.updateCurrencyMultiBox.service;

import dev.julioperez.littleTree.box.currencyBox.foreignExchange.domain.port.recordForeignExchangeBoxToReturnEgress.RecordForeignExchangeBoxToReturnEgress;
import dev.julioperez.littleTree.box.currencyBox.foreignExchange.domain.port.recordForeignExchangeToConfirmEgress.RecordForeignExchangeToConfirmEgress;
import dev.julioperez.littleTree.box.currencyBox.foreignExchange.domain.port.recordForeignExchangeToConfirmIngress.RecordForeignExchangeToConfirmIngress;
import dev.julioperez.littleTree.box.currencyBox.foreignExchange.domain.port.recordPendingForeignExchangeToEgress.RecordPendingForeignExchangeToEgress;
import dev.julioperez.littleTree.box.currencyBox.foreignExchange.domain.port.recordPendingForeignExchangeToIngress.RecordPendingForeignExchangeToIngress;
import dev.julioperez.littleTree.box.currencyBox.pesos.domain.port.recordPendingPesosBoxToEgress.RecordPendingPesosBoxToEgress;
import dev.julioperez.littleTree.box.currencyBox.pesos.domain.port.recordPendingPesosBoxToIngress.RecordPendingPesosBoxToIngress;
import dev.julioperez.littleTree.box.currencyBox.pesos.domain.port.recordPesosBoxToConfirmEgress.RecordPesosBoxToConfirmEgress;
import dev.julioperez.littleTree.box.currencyBox.pesos.domain.port.recordPesosBoxToConfirmIngress.RecordPesosBoxToConfirmIngress;
import dev.julioperez.littleTree.box.currencyBox.pesos.domain.port.recordPesosBoxToPayCommission.RecordPesosBoxToPayCommission;
import dev.julioperez.littleTree.box.currencyBox.pesos.domain.port.recordPesosBoxToReturnEgress.RecordPesosBoxToReturnEgress;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.currencyBox.officeDebt.domain.port.manageOfficeDebt.ManageOfficeDebt;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.getCurrencyMultibox.GetCurrencyMultibox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.updateCurrencyMultiBox.UpdateCurrencyMultiBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.updateCurrencyMultiBox.UpdateCurrencyMultiBoxOutputPort;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;

import java.util.List;
import java.util.Objects;

public class UpdateCurrencyMultiBoxService implements UpdateCurrencyMultiBox {
    private final UpdateCurrencyMultiBoxOutputPort updateCurrencyMultiBoxOutputPort;
    private final GetCurrencyMultibox getCurrencyMultibox;
    private final RecordPendingForeignExchangeToIngress recordPendingForeignExchangeToIngress;
    private final RecordForeignExchangeToConfirmIngress recordForeignExchangeToConfirmIngress;
    private final RecordForeignExchangeToConfirmEgress recordForeignExchangeToConfirmEgress;
    private final RecordForeignExchangeBoxToReturnEgress recordForeignExchangeBoxToReturnEgress;
    private final RecordPendingForeignExchangeToEgress recordPendingForeignExchangeToEgress;
    private final RecordPesosBoxToConfirmEgress recordPesosBoxToConfirmEgress;
    private final RecordPesosBoxToConfirmIngress recordPesosBoxToConfirmIngress;
    private final RecordPesosBoxToReturnEgress recordPesosBoxToReturnEgress;
    private final RecordPendingPesosBoxToEgress recordPendingPesosBoxToEgress;
    private final RecordPendingPesosBoxToIngress recordPendingPesosBoxToIngress;
    private final RecordPesosBoxToPayCommission recordPesosBoxToPayCommission;
    private final ManageOfficeDebt manageOfficeDebt;

    public UpdateCurrencyMultiBoxService(UpdateCurrencyMultiBoxOutputPort updateCurrencyMultiBoxOutputPort, GetCurrencyMultibox getCurrencyMultibox, RecordPendingForeignExchangeToIngress recordPendingForeignExchangeToIngress, RecordForeignExchangeToConfirmIngress recordForeignExchangeToConfirmIngress, RecordForeignExchangeToConfirmEgress recordForeignExchangeToConfirmEgress, RecordForeignExchangeBoxToReturnEgress recordForeignExchangeBoxToReturnEgress, RecordPendingForeignExchangeToEgress recordPendingForeignExchangeToEgress, RecordPesosBoxToConfirmEgress recordPesosBoxToConfirmEgress, RecordPesosBoxToConfirmIngress recordPesosBoxToConfirmIngress, RecordPesosBoxToReturnEgress recordPesosBoxToReturnEgress, RecordPendingPesosBoxToEgress recordPendingPesosBoxToEgress, RecordPendingPesosBoxToIngress recordPendingPesosBoxToIngress, RecordPesosBoxToPayCommission recordPesosBoxToPayCommission, ManageOfficeDebt manageOfficeDebt) {
        this.updateCurrencyMultiBoxOutputPort = updateCurrencyMultiBoxOutputPort;
        this.getCurrencyMultibox = getCurrencyMultibox;
        this.recordPendingForeignExchangeToIngress = recordPendingForeignExchangeToIngress;
        this.recordForeignExchangeToConfirmIngress = recordForeignExchangeToConfirmIngress;
        this.recordForeignExchangeToConfirmEgress = recordForeignExchangeToConfirmEgress;
        this.recordForeignExchangeBoxToReturnEgress = recordForeignExchangeBoxToReturnEgress;
        this.recordPendingForeignExchangeToEgress = recordPendingForeignExchangeToEgress;
        this.recordPesosBoxToConfirmEgress = recordPesosBoxToConfirmEgress;
        this.recordPesosBoxToConfirmIngress = recordPesosBoxToConfirmIngress;
        this.recordPesosBoxToReturnEgress = recordPesosBoxToReturnEgress;
        this.recordPendingPesosBoxToEgress = recordPendingPesosBoxToEgress;
        this.recordPendingPesosBoxToIngress = recordPendingPesosBoxToIngress;
        this.recordPesosBoxToPayCommission = recordPesosBoxToPayCommission;
        this.manageOfficeDebt = manageOfficeDebt;
    }

    @Override
    public boolean reserveDoneCurrencyBoxAfterOfConfirmBuyOperation(BuyOperation buyOperation) {
        List<CurrencyMultiBox> currenciesMultiboxByOperationId = updateCurrencyMultiBoxOutputPort.getCurrenciesMultiboxByOperationId(buyOperation.getId());
        CurrencyMultiBox foreignCurrencyBox = getCurrencyBoxByValues(buyOperation.getCurrencyMultiBox(), currenciesMultiboxByOperationId);
        String egressBox = buyOperation.hasOfficeCheck() ? CurrencyBox.PESO_OFFICE.value() : CurrencyBox.PESO.value();
        CurrencyMultiBox pesosOrOfficeBox = getCurrencyBoxByValues(egressBox, currenciesMultiboxByOperationId);

        Float actualQuantityByForeignExchangeBox = getActualQuantityOfCurrencyBoxByDescription(foreignCurrencyBox.getCurrencyBox());
        Float actualQuantityByPesosOrOfficeBox = getActualQuantityOfCurrencyBoxByDescription(egressBox);

        CurrencyMultiBox foreignExchangeToIngress = recordForeignExchangeToConfirmIngress.execute(foreignCurrencyBox, buyOperation, actualQuantityByForeignExchangeBox);
        CurrencyMultiBox pesosOrOfficeBoxToEgress =
                buyOperation.hasOfficeCheck()
                ? manageOfficeDebt.recordOfficeBoxToConfirmEgress(pesosOrOfficeBox, buyOperation,actualQuantityByPesosOrOfficeBox)
                : recordPesosBoxToConfirmEgress.execute(pesosOrOfficeBox, buyOperation,actualQuantityByPesosOrOfficeBox);

        //todo: question, what happen if quantity of box is less of 0?
        if(pesosOrOfficeBoxToEgress.getQuantity() < 0) throw new IllegalArgumentException(String.format("Quantity of box %s cant be less of zero", pesosOrOfficeBox.getCurrencyBox()));
        List<CurrencyMultiBox> multiBoxesUpdated = updateCurrencyMultiBoxOutputPort.currencyMultiBoxes(List.of(foreignExchangeToIngress, pesosOrOfficeBoxToEgress));
        return multiBoxesUpdated.size() == 2;
    }
    @Override
    public boolean reserveDoneCurrencyBoxAfterOfConfirmSellOperation(SellOperation sellOperation) {
        List<CurrencyMultiBox> currenciesMultiboxByOperationId = updateCurrencyMultiBoxOutputPort.getCurrenciesMultiboxByOperationId(sellOperation.getId());
        CurrencyMultiBox foreignCurrencyBox = getCurrencyBoxByValues(sellOperation.getCurrencyMultiBox(), currenciesMultiboxByOperationId);
        CurrencyMultiBox pesosBox = getCurrencyBoxByValues(CurrencyBox.PESO.value(), currenciesMultiboxByOperationId);

        CurrencyMultiBox foreignExchangeToEgress = recordForeignExchangeToConfirmEgress.execute(foreignCurrencyBox, sellOperation);
        CurrencyMultiBox pesosBoxToIngress = recordPesosBoxToConfirmIngress.execute(pesosBox, sellOperation);

        //todo: question, what happen if quantity of box is less of 0?
        //if(foreignExchangeToEgress.getQuantity() < 0) throw new IllegalArgumentException(String.format("Quantity of box %s cant be less of zero", foreignExchangeToEgress.getCurrencyBox()));
        List<CurrencyMultiBox> multiBoxesUpdated = updateCurrencyMultiBoxOutputPort.currencyMultiBoxes(List.of(foreignExchangeToEgress, pesosBoxToIngress));
        return multiBoxesUpdated.size() == 2;
    }
    public boolean reservePendingCurrencyBoxAfterOfBuyOperation(List<BuyOperation> buyOperations){
        //todo:this reserve is only for pending, to be used to show how many currencies have available on box
        //todo:question, foreign currency should be same but in confirmation of operation should change quantity?
        //todo:to done operation need call to reserveForeignCurrencyOnBoxToBeSell method
        List<Boolean> allResults = buyOperations.stream().map(this::reserveParticularPendingCurrencyBoxAfterOfBuyOperation).toList();
        return allResults.stream().allMatch(particularResult -> particularResult.equals(true));
    }
    @Override
    public boolean reservePendingCurrencyBoxAfterOfSellOperation(List<SellOperation> sellOperations) {
        List<Boolean> allResults = sellOperations.stream().map(this::reserveParticularPendingCurrencyBoxAfterOfSellOperation).toList();
        return allResults.stream().allMatch(particularResult -> particularResult.equals(true));
    }
    @Override
    public boolean returnQuantityOnCurrencyBoxByCancelledBuyOperation(BuyOperation buyOperation) {
        List<CurrencyMultiBox> currenciesMultiboxByOperationId = updateCurrencyMultiBoxOutputPort.getCurrenciesMultiboxByOperationId(buyOperation.getId());
        String egressBox = buyOperation.hasOfficeCheck() ? CurrencyBox.PESO_OFFICE.value() : CurrencyBox.PESO.value();
        CurrencyMultiBox pesosOrOfficeBox = getCurrencyBoxByValues(egressBox, currenciesMultiboxByOperationId);
        Float actualQuantityByPesosOrOfficeBox = getActualQuantityOfCurrencyBoxByDescription(egressBox);

        CurrencyMultiBox pesosOrOfficeBoxToReturnEgress =
                buyOperation.hasOfficeCheck()
                ? manageOfficeDebt.recordOfficeBoxToReturnEgress(pesosOrOfficeBox, buyOperation, actualQuantityByPesosOrOfficeBox)
                : recordPesosBoxToReturnEgress.execute(pesosOrOfficeBox, buyOperation, actualQuantityByPesosOrOfficeBox);

        //todo: question, what happen if quantity of box is less of 0?
        if(pesosOrOfficeBoxToReturnEgress.getQuantity() < 0) throw new IllegalArgumentException(String.format("Quantity of box %s cant be less of zero", pesosOrOfficeBoxToReturnEgress.getCurrencyBox()));
        List<CurrencyMultiBox> multiBoxesUpdated = updateCurrencyMultiBoxOutputPort.currencyMultiBoxes(List.of(pesosOrOfficeBoxToReturnEgress));
        return multiBoxesUpdated.size() == 1;
    }
    private Float getActualQuantityOfCurrencyBoxByDescription(String currencyBoxDescription){
        CurrencyBox currencyBox = CurrencyBox.returnCurrencyBoxByDescription(currencyBoxDescription);
        return getActualQuantityOfCurrencyBoxCaller(currencyBox);
    }
    private Float getActualQuantityOfCurrencyBoxCaller(CurrencyBox currencyBox){
        return updateCurrencyMultiBoxOutputPort
                .getActualQuantityByCurrencyBox(currencyBox)
                .getQuantity();
    }
    @Override
    public boolean returnQuantityOnCurrencyBoxByCancelledSellOperation(SellOperation sellOperation) {
        List<CurrencyMultiBox> currenciesMultiboxByOperationId = updateCurrencyMultiBoxOutputPort.getCurrenciesMultiboxByOperationId(sellOperation.getId());
        CurrencyMultiBox foreignCurrencyBox = getCurrencyBoxByValues(sellOperation.getCurrencyMultiBox(), currenciesMultiboxByOperationId);
        Float actualQuantityByExchangeCurrencyBox = getActualQuantityOfCurrencyBoxByDescription(foreignCurrencyBox.getCurrencyBox());
        CurrencyMultiBox foreignCurrencyBoxToReturnEgress = recordForeignExchangeBoxToReturnEgress.execute(foreignCurrencyBox, sellOperation, actualQuantityByExchangeCurrencyBox);
        //todo: question, what happen if quantity of box is less of 0?
        if(foreignCurrencyBoxToReturnEgress.getQuantity() < 0) throw new IllegalArgumentException(String.format("Quantity of box %s cant be less of zero", foreignCurrencyBoxToReturnEgress.getCurrencyBox()));
        List<CurrencyMultiBox> multiBoxesUpdated = updateCurrencyMultiBoxOutputPort.currencyMultiBoxes(List.of(foreignCurrencyBoxToReturnEgress));
        return multiBoxesUpdated.size() == 1;
    }

    @Override
    public boolean updateCurrenciesMultiboxBoxes(List<CurrencyMultiBox> newCurrenciesMultiBoxes) {
        return Objects.nonNull(updateCurrencyMultiBoxOutputPort.saveCurrencyMultiBox(newCurrenciesMultiBoxes));
    }


    private boolean reserveParticularPendingCurrencyBoxAfterOfBuyOperation(BuyOperation buyOperation){
        List<String> boxToUse = buyOperation.hasOfficeCheck()
                ? List.of(CurrencyBox.PESO_OFFICE.value(), buyOperation.getCurrencyMultiBox())
                : List.of(CurrencyBox.PESO.value(), buyOperation.getCurrencyMultiBox());
        List<CurrencyMultiBox> currenciesMultiboxToUpdate = updateCurrencyMultiBoxOutputPort.getCurrenciesMultiboxByValues(boxToUse);
        if(boxToUse.size() != currenciesMultiboxToUpdate.size()) throw new IllegalArgumentException(String.format("list should has a size of %s, but return a size of %s , should return same quantity",boxToUse.size(), currenciesMultiboxToUpdate.size()));
        return instanceIngressAndEgressToSaveToBuyOperation(currenciesMultiboxToUpdate, buyOperation);
    }
    private boolean reserveParticularPendingCurrencyBoxAfterOfSellOperation(SellOperation sellOperation){
        List<String> currenciesValues = List.of(CurrencyBox.PESO.value(), sellOperation.getCurrencyMultiBox());
        List<CurrencyMultiBox> currenciesMultiboxToUpdate = updateCurrencyMultiBoxOutputPort.getCurrenciesMultiboxByValues(currenciesValues);
        if(currenciesValues.size() != currenciesMultiboxToUpdate.size()) throw new IllegalArgumentException(String.format("list should has a size of %s, but return a size of %s , should return same quantity",currenciesValues.size(), currenciesMultiboxToUpdate.size()));
        return instanceIngressAndEgressToSaveToSellOperation(currenciesMultiboxToUpdate, sellOperation);
    }
    private CurrencyMultiBox getCurrencyBoxByValues(String currencyBox, List<CurrencyMultiBox> currenciesMultiboxToUpdate){
        List<CurrencyMultiBox> currencyMultiBoxes = currenciesMultiboxToUpdate.stream().filter(particular -> currencyBox.equals(particular.getCurrencyBox())).toList();
        if(currencyMultiBoxes.size() != 1) throw new IllegalArgumentException(String.format("list should has a size of 1, but return a size of %s , should return same quantity",currencyMultiBoxes.size()));
        return currencyMultiBoxes.get(0);
    }
    private boolean instanceIngressAndEgressToSaveToBuyOperation(List<CurrencyMultiBox> currenciesMultiboxToUpdate, BuyOperation buyOperation){
        CurrencyMultiBox foreignExchangeBox = getCurrencyBoxByValues(buyOperation.getCurrencyMultiBox(), currenciesMultiboxToUpdate);
        String egressBox = buyOperation.hasOfficeCheck() ? CurrencyBox.PESO_OFFICE.value() : CurrencyBox.PESO.value();
        CurrencyMultiBox pesosOrOfficeBox = getCurrencyBoxByValues(egressBox, currenciesMultiboxToUpdate);

        CurrencyMultiBox foreignExchangeToIngress = recordPendingForeignExchangeToIngress.execute(foreignExchangeBox, buyOperation);
        CurrencyMultiBox pesosOrOfficeBoxToEgress = buyOperation.hasOfficeCheck()
                ? manageOfficeDebt.recordPendingOfficeBoxToEgress(pesosOrOfficeBox, buyOperation)
                : recordPendingPesosBoxToEgress.execute(pesosOrOfficeBox, buyOperation);

        //todo: question, what happen if quantity of box is less of 0?
        if(pesosOrOfficeBoxToEgress.getQuantity() < 0) throw new IllegalArgumentException(String.format("Quantity of box %s cant be less of zero", pesosOrOfficeBox.getCurrencyBox()));
        List<CurrencyMultiBox> multiBoxesUpdated = updateCurrencyMultiBoxOutputPort.currencyMultiBoxes(List.of(foreignExchangeToIngress, pesosOrOfficeBoxToEgress));
        return multiBoxesUpdated.size() == 2;
    }
    private boolean instanceIngressAndEgressToSaveToSellOperation(List<CurrencyMultiBox> currenciesMultiboxToUpdate, SellOperation sellOperation){
        CurrencyMultiBox foreignExchangeBox = getCurrencyBoxByValues(sellOperation.getCurrencyMultiBox(), currenciesMultiboxToUpdate);
        CurrencyMultiBox pesosBox = getCurrencyBoxByValues(CurrencyBox.PESO.value(), currenciesMultiboxToUpdate);;


        CurrencyMultiBox foreignExchangeToEgress = recordPendingForeignExchangeToEgress.execute(foreignExchangeBox, sellOperation);
        CurrencyMultiBox pesosOrOfficeBoxToIngress = recordPendingPesosBoxToIngress.execute(pesosBox, sellOperation);

        //todo: question, what happen if quantity of box is less of 0?
        if(foreignExchangeToEgress.getQuantity() < 0) throw new IllegalArgumentException(String.format("Quantity of box %s cant be less of zero", foreignExchangeToEgress.getCurrencyBox()));
        List<CurrencyMultiBox> multiBoxesUpdated = updateCurrencyMultiBoxOutputPort.currencyMultiBoxes(List.of(foreignExchangeToEgress, pesosOrOfficeBoxToIngress));
        return multiBoxesUpdated.size() == 2;
    }

    public boolean egressPesosBoxByCommissionPayment(Float sellerCommissionQuantity){
        try {
            CurrencyMultiBox lastCurrencyMultiboxByCurrencyBox = getCurrencyMultibox.getLastCurrencyMultiboxByCurrencyBox(CurrencyBox.PESO);
            CurrencyMultiBox currencyMultiBox = recordPesosBoxToPayCommission.execute(lastCurrencyMultiboxByCurrencyBox, sellerCommissionQuantity);
            updateCurrencyMultiBoxOutputPort.saveCurrencyMultiBox(List.of(currencyMultiBox));
            return true;
        }catch (Exception exception){
            return false;
        }
    }

}
