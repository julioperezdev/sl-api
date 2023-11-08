package dev.julioperez.littleTree.box.balance.application.modelMapper;

import dev.julioperez.littleTree.box.balance.domain.model.Balance;
import dev.julioperez.littleTree.box.balance.domain.port.mapper.BalanceMapper;
import dev.julioperez.littleTree.box.balance.infrastructure.repository.entity.BalanceEntity;
import java.util.List;

public class BalanceModelMapper implements BalanceMapper {
    @Override
    public Balance toBalanceModel(BalanceEntity balanceEntity) {
        return new Balance(
                balanceEntity.getId(),
                balanceEntity.getProfit(),
                balanceEntity.getOperationId(),
                balanceEntity.getCreatedAt(),
                balanceEntity.getUpdatedAt(),
                balanceEntity.getOperationType(),
                balanceEntity.getQuantityOperation());
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
                balance.getUpdatedAt(),
                balance.getOperationType(),
                balance.getQuantityOperation());
    }
}
