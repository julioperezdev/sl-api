package dev.julioperez.littleTree.box.domain.port.updateCurrencyMultiBox;

import dev.julioperez.littleTree.operation.domain.dto.SellOperationData;
import dev.julioperez.littleTree.operation.domain.model.buyOperation.BuyOperation;
import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperation;

import java.util.List;

public interface UpdateCurrencyMultiBox {
    boolean reserveDoneCurrencyBoxAfterOfConfirmBuyOperation(BuyOperation buyOperation);
    boolean reserveDoneCurrencyBoxAfterOfConfirmSellOperation(SellOperation sellOperation);
    boolean reservePendingCurrencyBoxAfterOfBuyOperation(List<BuyOperation> buyOperations);
    boolean reservePendingCurrencyBoxAfterOfSellOperation(List<SellOperation> sellOperations);
    boolean returnQuantityOnCurrencyBoxByCancelledBuyOperation(BuyOperation buyOperation);
    boolean returnQuantityOnCurrencyBoxByCancelledSellOperation(SellOperation sellOperation);
}
