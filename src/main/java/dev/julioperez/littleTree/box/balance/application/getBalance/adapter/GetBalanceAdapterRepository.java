package dev.julioperez.littleTree.box.balance.application.getBalance.adapter;

import dev.julioperez.littleTree.box.balance.domain.model.Balance;
import dev.julioperez.littleTree.box.balance.domain.port.getBalance.GetBalanceOutputPort;
import dev.julioperez.littleTree.box.balance.domain.port.mapper.BalanceMapper;
import dev.julioperez.littleTree.box.balance.infrastructure.repository.dao.BalanceDao;
import dev.julioperez.littleTree.box.balance.infrastructure.repository.entity.BalanceEntity;

import java.util.Collections;
import java.util.List;

public class GetBalanceAdapterRepository implements GetBalanceOutputPort {
    private final BalanceDao balanceDao;
    private final BalanceMapper balanceMapper;

    public GetBalanceAdapterRepository(BalanceDao balanceDao, BalanceMapper balanceMapper) {
        this.balanceDao = balanceDao;
        this.balanceMapper = balanceMapper;
    }

    @Override
    public List<Balance> getBalances() {
        List<BalanceEntity> balances = balanceDao.findAll();
        return balances.isEmpty()
                ? Collections.emptyList()
                : balanceMapper.toBalanceModel(balances);
    }
}
