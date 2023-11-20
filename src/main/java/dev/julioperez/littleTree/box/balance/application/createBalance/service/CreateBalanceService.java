package dev.julioperez.littleTree.box.balance.application.createBalance.service;

import dev.julioperez.littleTree.box.balance.domain.model.Balance;
import dev.julioperez.littleTree.box.balance.domain.port.createBalance.CreateBalance;
import dev.julioperez.littleTree.box.balance.domain.port.getBalance.GetBalance;
import dev.julioperez.littleTree.box.balance.domain.port.saveOrUpdateBalance.SaveOrUpdateBalance;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;

import java.sql.Date;
import java.time.Instant;
import java.util.UUID;

public class CreateBalanceService implements CreateBalance {
    private final SaveOrUpdateBalance saveOrUpdateBalance;
    private final GetBalance getBalance;

    public CreateBalanceService(SaveOrUpdateBalance saveOrUpdateBalance, GetBalance getBalance) {
        this.saveOrUpdateBalance = saveOrUpdateBalance;
        this.getBalance = getBalance;
    }


    @Override
    public boolean execute(SellOperation sellOperation) {
        Float actualQuantity = getActualTotalProfit();
        Balance newBalance = new Balance(
                UUID.randomUUID().toString(),
                actualQuantity + sellOperation.getProfit(),
                sellOperation.getId(),
                Date.from(Instant.now()),
                Date.from(Instant.now()),
                "ganancia final",
                sellOperation.getProfit());
        return saveOrUpdateBalance.execute(newBalance) != null;
    }

    private Float getActualTotalProfit(){
        Balance actualQuantity = getBalance.getLastBalance();
        return actualQuantity.getProfit();
    }
}
