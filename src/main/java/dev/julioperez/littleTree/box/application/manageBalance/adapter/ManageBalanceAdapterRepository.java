package dev.julioperez.littleTree.box.application.manageBalance.adapter;

import dev.julioperez.littleTree.box.domain.model.Balance;
import dev.julioperez.littleTree.box.domain.port.manageBalance.ManageBalanceOutputPort;
import dev.julioperez.littleTree.box.domain.port.mapper.BalanceMapper;
import dev.julioperez.littleTree.box.infrastructure.repository.dao.BalanceDao;
import dev.julioperez.littleTree.box.infrastructure.repository.entity.BalanceEntity;

import java.util.List;

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
        return balanceMapper.toBalanceModel(balances);
    }
}
