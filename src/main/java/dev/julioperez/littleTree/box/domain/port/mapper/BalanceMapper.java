package dev.julioperez.littleTree.box.domain.port.mapper;

import dev.julioperez.littleTree.box.domain.model.Balance;
import dev.julioperez.littleTree.box.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.infrastructure.repository.entity.BalanceEntity;
import dev.julioperez.littleTree.box.infrastructure.repository.entity.CurrencyMultiBoxEntity;

import java.util.List;

public interface BalanceMapper {
    Balance toBalanceModel(BalanceEntity balanceEntity);
    List<Balance> toBalanceModel(List<BalanceEntity> balanceEntities);
    BalanceEntity toBalanceEntity(Balance balance);
}
