package dev.julioperez.littleTree.box.balance.domain.port.mapper;

import dev.julioperez.littleTree.box.balance.domain.model.Balance;
import dev.julioperez.littleTree.box.balance.infrastructure.repository.entity.BalanceEntity;

import java.util.List;

public interface BalanceMapper {
    Balance toBalanceModel(BalanceEntity balanceEntity);
    List<Balance> toBalanceModel(List<BalanceEntity> balanceEntities);
    BalanceEntity toBalanceEntity(Balance balance);
}
