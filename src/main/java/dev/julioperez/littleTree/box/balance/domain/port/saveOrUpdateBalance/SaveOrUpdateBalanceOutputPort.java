package dev.julioperez.littleTree.box.balance.domain.port.saveOrUpdateBalance;

import dev.julioperez.littleTree.box.balance.domain.model.Balance;

public interface SaveOrUpdateBalanceOutputPort {
    Balance saveOrUpdateBalance(Balance newBalance);
}
