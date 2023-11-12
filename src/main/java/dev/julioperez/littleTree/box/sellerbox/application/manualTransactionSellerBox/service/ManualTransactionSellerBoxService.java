package dev.julioperez.littleTree.box.sellerbox.application.manualTransactionSellerBox.service;

import dev.julioperez.littleTree.box.sellerbox.domain.dto.ManualTransactionSellerBoxRequest;
import dev.julioperez.littleTree.box.sellerbox.domain.enums.SellerBoxNames;
import dev.julioperez.littleTree.box.sellerbox.domain.model.SellerBox;
import dev.julioperez.littleTree.box.sellerbox.domain.port.manageSellerBox.ManageSellerBox;
import dev.julioperez.littleTree.box.sellerbox.domain.port.manualTransactionSellerBox.ManualTransactionSellerBox;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationType;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class ManualTransactionSellerBoxService implements ManualTransactionSellerBox {
    private final ManageSellerBox manageSellerBox;

    public ManualTransactionSellerBoxService(ManageSellerBox manageSellerBox) {
        this.manageSellerBox = manageSellerBox;
    }

    public boolean execute(ManualTransactionSellerBoxRequest manualTransactionSellerBoxRequest) {
        SellerBoxNames sellerBoxNames = SellerBoxNames.returnSellerBoxNamesByValue(manualTransactionSellerBoxRequest.sellerBoxName());
        validateManualType(manualTransactionSellerBoxRequest.manualOperationType());
        SellerBox lastSellerBoxByName = manageSellerBox.getLastSellerBoxByName(sellerBoxNames.value());
        Float newTotal = newTotalByManualTransaction(manualTransactionSellerBoxRequest, lastSellerBoxByName);
        SellerBox newCurrencyMultiBox = toNewCurrencyMultiBox(lastSellerBoxByName, newTotal, manualTransactionSellerBoxRequest);
        return Objects.nonNull(manageSellerBox.saveSellerBox(newCurrencyMultiBox));
    }

    private Float newTotalByManualTransaction(ManualTransactionSellerBoxRequest manualTransactionRequest, SellerBox lastSellerBoxByName){
        return isManualIngress(manualTransactionRequest.manualOperationType())
                ? lastSellerBoxByName.addQuantity(manualTransactionRequest.quantity())
                : lastSellerBoxByName.reduceQuantity(manualTransactionRequest.quantity());
    }
    private SellerBox toNewCurrencyMultiBox(SellerBox sellerBox, Float newTotal, ManualTransactionSellerBoxRequest manualTransactionRequest) {
        return new SellerBox(
                UUID.randomUUID().toString(),
                newTotal,
                manualTransactionRequest.quantity(),
                sellerBox.getName(),
                OperationType.returnOperationTypeByDescription(manualTransactionRequest.manualOperationType()).value(),
                Date.from(Instant.now()),
                Date.from(Instant.now()));
    }

    private boolean isManualIngress(String manualType){
        if(OperationType.isCashIncomeOperation(manualType)) return true;
        else if(OperationType.isCashEgressOperation(manualType)) return false;
        else throw new IllegalArgumentException("on isManualIngress dont match with valid string options");
    }

    private void validateManualType(String manualType){
        if(!OperationType.isManualOperation(manualType))
            throw new IllegalArgumentException("on validateManualType dont match with valid string options");
    }

}
