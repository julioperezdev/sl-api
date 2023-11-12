package dev.julioperez.littleTree.box.balance.application.manageBalance.service;

import dev.julioperez.littleTree.box.balance.domain.model.Balance;
import dev.julioperez.littleTree.box.balance.domain.port.manageBalance.ManageBalance;
import dev.julioperez.littleTree.box.balance.domain.port.manageBalance.ManageBalanceOutputPort;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;

import java.sql.Date;
import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class ManageBalanceService implements ManageBalance {
    private final ManageBalanceOutputPort manageBalanceOutputPort;

    public ManageBalanceService(ManageBalanceOutputPort manageBalanceOutputPort) {
        this.manageBalanceOutputPort = manageBalanceOutputPort;
    }
    public List<Balance> getBalance(){
        return manageBalanceOutputPort.getBalances();
    }
    private Float getActualTotalProfit(){
        Balance actualQuantity = manageBalanceOutputPort.getActualQuantity();
        return actualQuantity.getProfit();
    }
    public boolean createBalance(SellOperation sellOperation){
        Float actualQuantity = getActualTotalProfit();
        Balance newBalance = new Balance(
                UUID.randomUUID().toString(),
                actualQuantity + sellOperation.getProfit(),
                sellOperation.getId(),
                Date.from(Instant.now()),
                Date.from(Instant.now()),
                "ganancia final",
                sellOperation.getProfit());
        return manageBalanceOutputPort.saveOrUpdateBalance(newBalance) != null;
    }

    @Override
    public List<Balance> getBalanceOrdered() {
        return manageBalanceOutputPort.getBalances()
                .stream()
                .sorted(Comparator.comparing(Balance::getUpdatedAt).reversed())
                .toList();
    }

    @Override
    public Balance getLastBalance() {
        return manageBalanceOutputPort.getBalances()
                .stream()
                .max(Comparator.comparing(Balance::getUpdatedAt))
                .orElse(null);
    }


}
