package dev.julioperez.littleTree.box.balance.application.assignSellerBox.service;

import dev.julioperez.littleTree.box.balance.domain.dto.AssignSellerBoxRequest;
import dev.julioperez.littleTree.box.balance.domain.model.Balance;
import dev.julioperez.littleTree.box.balance.domain.port.assignToSellerBox.AssignSellerBox;
import dev.julioperez.littleTree.box.balance.domain.port.manageBalance.ManageBalance;
import dev.julioperez.littleTree.box.balance.domain.port.saveOrUpdateBalance.SaveOrUpdateBalance;
import dev.julioperez.littleTree.box.sellerbox.domain.port.manageSellerBox.ManageSellerBox;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationType;

import java.sql.Date;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class AssignSellerBoxService implements AssignSellerBox {

    private final ManageBalance manageBalance;
    private final SaveOrUpdateBalance saveOrUpdateBalance;
    private final ManageSellerBox manageSellerBox;

    public AssignSellerBoxService(ManageBalance manageBalance, SaveOrUpdateBalance saveOrUpdateBalance, ManageSellerBox manageSellerBox) {
        this.manageBalance = manageBalance;
        this.saveOrUpdateBalance = saveOrUpdateBalance;
        this.manageSellerBox = manageSellerBox;
    }

    @Override
    public boolean execute(AssignSellerBoxRequest assignSellerBoxRequest) {
        Balance lastBalance = manageBalance.getLastBalance();
        if(Objects.isNull(lastBalance)) throw new IllegalArgumentException("cant assign profit to seller box because dont exist a balance");
        if(assignSellerBoxRequest.quantity() > lastBalance.getProfit()) throw new IllegalArgumentException("Cant send a quantity mayor of total of balance box");
        //what happen if the balance is negative, can assign to seller box?
        boolean isSavedSellerBox = manageSellerBox.assignSellerBox(assignSellerBoxRequest);
        Balance newBalanceWithReducedProfit = newBalanceWithReducedProfit(lastBalance, assignSellerBoxRequest.quantity());
        saveOrUpdateBalance.execute(newBalanceWithReducedProfit);
        return true;
    }

    private Balance newBalanceWithReducedProfit(Balance balance, Float quantity){
        Float newProfitQuantity = balance.getProfit() - quantity;
        return new Balance(
                UUID.randomUUID().toString(),
                newProfitQuantity,
                null,
                balance.getCreatedAt(),
                Date.from(Instant.now()),
                OperationType.ASSIGN_BOX.value(),
                quantity);
    }
}
