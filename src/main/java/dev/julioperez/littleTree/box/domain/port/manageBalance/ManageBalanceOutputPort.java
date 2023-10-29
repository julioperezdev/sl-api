package dev.julioperez.littleTree.box.domain.port.manageBalance;

import dev.julioperez.littleTree.box.domain.model.Balance;

import java.util.List;

public interface ManageBalanceOutputPort {
    Balance saveOrUpdateBalance(Balance balance);
    List<Balance> getBalances();
    Balance getActualQuantity();
}
