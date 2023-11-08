package dev.julioperez.littleTree.box.balance.application.manageBalance.adapter;

import dev.julioperez.littleTree.box.balance.domain.model.Balance;
import dev.julioperez.littleTree.box.balance.domain.port.manageBalance.ManageBalanceOutputPort;
import dev.julioperez.littleTree.box.balance.domain.port.mapper.BalanceMapper;
import dev.julioperez.littleTree.box.balance.infrastructure.repository.dao.BalanceDao;
import dev.julioperez.littleTree.box.balance.infrastructure.repository.entity.BalanceEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ManageBalanceAdapterRepository implements ManageBalanceOutputPort {

    private final BalanceDao balanceDao;
    private final BalanceMapper balanceMapper;

    public ManageBalanceAdapterRepository(BalanceDao balanceDao, BalanceMapper balanceMapper) {
        this.balanceDao = balanceDao;
        this.balanceMapper = balanceMapper;
    }

    public Balance saveOrUpdateBalance(Balance balance){
        BalanceEntity balanceEntity = balanceMapper.toBalanceEntity(balance);
        balanceDao.save(balanceEntity);
        return balanceMapper.toBalanceModel(balanceEntity);
    }

    @Override
    public List<Balance> getBalances() {
        List<BalanceEntity> balances = balanceDao.findAll();
        return balances.isEmpty()
                ? Collections.emptyList()
                : balanceMapper.toBalanceModel(balances);
    }

    @Override
    public Balance getActualQuantity() {
        Optional<BalanceEntity> optionalBalance = balanceDao.getLastBalance();
        if(optionalBalance.isEmpty()) throw new IllegalArgumentException("getActualQuantity does not return value");
        return balanceMapper.toBalanceModel(optionalBalance.get());
    }
}
