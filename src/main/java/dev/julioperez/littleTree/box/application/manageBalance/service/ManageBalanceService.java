package dev.julioperez.littleTree.box.application.manageBalance.service;

import dev.julioperez.littleTree.box.domain.model.Balance;
import dev.julioperez.littleTree.box.domain.port.manageBalance.ManageBalance;
import dev.julioperez.littleTree.box.domain.port.manageBalance.ManageBalanceOutputPort;
import dev.julioperez.littleTree.box.domain.port.mapper.BalanceMapper;
import dev.julioperez.littleTree.box.infrastructure.repository.entity.BalanceEntity;

import java.util.List;

public class ManageBalanceService implements ManageBalance {
    private final ManageBalanceOutputPort manageBalanceOutputPort;

    public ManageBalanceService(ManageBalanceOutputPort manageBalanceOutputPort) {
        this.manageBalanceOutputPort = manageBalanceOutputPort;
    }
    public List<Balance> getBalance(){
        return manageBalanceOutputPort.getBalances();
    }
    public boolean createBalance(Balance newBalance){
        return manageBalanceOutputPort.saveOrUpdateBalance(newBalance) != null;
    }


}
