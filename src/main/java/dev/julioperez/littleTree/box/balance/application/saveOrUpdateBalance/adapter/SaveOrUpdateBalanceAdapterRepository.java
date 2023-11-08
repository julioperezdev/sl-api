package dev.julioperez.littleTree.box.balance.application.saveOrUpdateBalance.adapter;

import dev.julioperez.littleTree.box.balance.domain.model.Balance;
import dev.julioperez.littleTree.box.balance.domain.port.mapper.BalanceMapper;
import dev.julioperez.littleTree.box.balance.domain.port.saveOrUpdateBalance.SaveOrUpdateBalanceOutputPort;
import dev.julioperez.littleTree.box.balance.infrastructure.repository.dao.BalanceDao;
import dev.julioperez.littleTree.box.balance.infrastructure.repository.entity.BalanceEntity;

import java.util.Objects;

public class SaveOrUpdateBalanceAdapterRepository implements SaveOrUpdateBalanceOutputPort {

    private final BalanceDao balanceDao;
    private final BalanceMapper balanceMapper;

    public SaveOrUpdateBalanceAdapterRepository(BalanceDao balanceDao, BalanceMapper balanceMapper) {
        this.balanceDao = balanceDao;
        this.balanceMapper = balanceMapper;

    }

    @Override
    public Balance saveOrUpdateBalance(Balance newBalance) {
        BalanceEntity balanceEntity = balanceMapper.toBalanceEntity(newBalance);
        BalanceEntity balanceEntitySaved = balanceDao.save(balanceEntity);
        return balanceMapper.toBalanceModel(balanceEntitySaved);
    }
}
