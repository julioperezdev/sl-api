package dev.julioperez.littleTree.box.domain.port.manageOfficeDebt;

import dev.julioperez.littleTree.box.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.domain.port.updateCurrencyMultiBox.UpdateCurrencyMultiBox;
import dev.julioperez.littleTree.operation.domain.model.buyOperation.BuyOperation;

public interface ManageOfficeDebt{
    CurrencyMultiBox recordPendingOfficeBoxToEgress(CurrencyMultiBox officeBox, BuyOperation buyOperation);
    CurrencyMultiBox recordOfficeBoxToReturnEgress(CurrencyMultiBox officeBox, BuyOperation buyOperation, Float actualQuantityOfOfficeBox);
    CurrencyMultiBox recordOfficeBoxToConfirmEgress(CurrencyMultiBox officeBox, BuyOperation buyOperation, Float actualQuantityOfOfficeBox);

    //CurrencyMultiBox payOfficeDebt(CurrencyMultiBox officeDebt, Float quantity);
}
