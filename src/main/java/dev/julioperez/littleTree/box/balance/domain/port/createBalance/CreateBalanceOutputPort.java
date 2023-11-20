package dev.julioperez.littleTree.box.balance.domain.port.createBalance;

import dev.julioperez.littleTree.box.balance.domain.model.Balance;

public interface CreateBalanceOutputPort {
    Balance saveBalance(Balance balance);
}
