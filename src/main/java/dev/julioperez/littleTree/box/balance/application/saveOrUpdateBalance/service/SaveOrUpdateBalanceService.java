package dev.julioperez.littleTree.box.balance.application.saveOrUpdateBalance.service;

import dev.julioperez.littleTree.box.balance.domain.model.Balance;
import dev.julioperez.littleTree.box.balance.domain.port.saveOrUpdateBalance.SaveOrUpdateBalance;
import dev.julioperez.littleTree.box.balance.domain.port.saveOrUpdateBalance.SaveOrUpdateBalanceOutputPort;

public class SaveOrUpdateBalanceService implements SaveOrUpdateBalance {

    private final SaveOrUpdateBalanceOutputPort saveOrUpdateBalanceOutputPort;

    public SaveOrUpdateBalanceService(SaveOrUpdateBalanceOutputPort saveOrUpdateBalanceOutputPort) {
        this.saveOrUpdateBalanceOutputPort = saveOrUpdateBalanceOutputPort;
    }

    @Override
    public Balance execute(Balance newBalance) {
        return saveOrUpdateBalanceOutputPort.saveOrUpdateBalance(newBalance);
    }
}
