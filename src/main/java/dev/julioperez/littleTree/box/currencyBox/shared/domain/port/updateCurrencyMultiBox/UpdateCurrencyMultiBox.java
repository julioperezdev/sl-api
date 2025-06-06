package dev.julioperez.littleTree.box.currencyBox.shared.domain.port.updateCurrencyMultiBox;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;

import java.util.List;

public interface UpdateCurrencyMultiBox {
    boolean reserveDoneCurrencyBoxAfterOfConfirmBuyOperation(BuyOperation buyOperation);
    boolean reserveDoneCurrencyBoxAfterOfConfirmSellOperation(SellOperation sellOperation);
    boolean reservePendingCurrencyBoxAfterOfBuyOperation(List<BuyOperation> buyOperations);
    boolean reservePendingCurrencyBoxAfterOfSellOperation(List<SellOperation> sellOperations);
    boolean returnQuantityOnCurrencyBoxByCancelledBuyOperation(BuyOperation buyOperation);
    boolean returnQuantityOnCurrencyBoxByCancelledSellOperation(SellOperation sellOperation);
    boolean updateCurrenciesMultiboxBoxes(List<CurrencyMultiBox> newCurrenciesMultiBoxes);
    boolean egressPesosBoxByCommissionPayment(Float sellerCommissionQuantity);
}
