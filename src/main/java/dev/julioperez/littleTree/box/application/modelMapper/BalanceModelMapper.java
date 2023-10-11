package dev.julioperez.littleTree.box.application.modelMapper;

import dev.julioperez.littleTree.box.domain.model.Balance;
import dev.julioperez.littleTree.box.domain.port.mapper.BalanceMapper;
import dev.julioperez.littleTree.box.infrastructure.repository.entity.BalanceEntity;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class BalanceModelMapper implements BalanceMapper {
    @Override
    public Balance toBalanceModel(BalanceEntity balanceEntity) {
        return new Balance(
                balanceEntity.getId(),
                balanceEntity.getProfit(),
                balanceEntity.getOperationId(),
                balanceEntity.getCreatedAt(),
                balanceEntity.getUpdatedAt());
    }

    @Override
    public List<Balance> toBalanceModel(List<BalanceEntity> balanceEntities) {
        return balanceEntities.stream()
                .map(this::toBalanceModel)
                .toList();
    }

    @Override
    public BalanceEntity toBalanceEntity(Balance balance) {
        return new BalanceEntity(
                balance.getId(),
                balance.getProfit(),
                balance.getOperationId(),
                balance.getCreatedAt(),
                balance.getUpdatedAt());
    }
}
