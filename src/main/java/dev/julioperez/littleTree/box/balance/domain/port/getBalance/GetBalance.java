package dev.julioperez.littleTree.box.balance.domain.port.getBalance;

import dev.julioperez.littleTree.box.balance.domain.model.Balance;

import java.util.List;

public interface GetBalance {
    List<Balance> getBalanceOrdered();
    Balance getLastBalance();


}
