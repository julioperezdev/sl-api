package dev.julioperez.littleTree.box.balance.domain.port.manageBalance;

import dev.julioperez.littleTree.box.balance.domain.model.Balance;

import java.util.List;

public interface ManageBalanceOutputPort {
    Balance saveOrUpdateBalance(Balance balance);
    List<Balance> getBalances();
    Balance getActualQuantity();
}
