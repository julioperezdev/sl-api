package dev.julioperez.littleTree.box.balance.application.getBalance.service;

import dev.julioperez.littleTree.box.balance.domain.model.Balance;
import dev.julioperez.littleTree.box.balance.domain.port.getBalance.GetBalance;
import dev.julioperez.littleTree.box.balance.domain.port.getBalance.GetBalanceOutputPort;

import java.util.Comparator;
import java.util.List;

public class GetBalanceService implements GetBalance {

    private final GetBalanceOutputPort getBalanceOutputPort;

    public GetBalanceService(GetBalanceOutputPort getBalanceOutputPort) {
        this.getBalanceOutputPort = getBalanceOutputPort;
    }

    @Override
    public List<Balance> getBalanceOrdered() {
        return getBalanceOutputPort.getBalances()
                .stream()
                .sorted(Comparator.comparing(Balance::getUpdatedAt).reversed())
                .toList();
    }

    @Override
    public Balance getLastBalance() {
        return getBalanceOutputPort.getBalances()
                .stream()
                .max(Comparator.comparing(Balance::getUpdatedAt))
                .orElse(null);
    }
}
