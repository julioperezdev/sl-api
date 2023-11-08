package dev.julioperez.littleTree.box.balance.domain.port.saveOrUpdateBalance;

import dev.julioperez.littleTree.box.balance.domain.model.Balance;

public interface SaveOrUpdateBalance {

    Balance execute(Balance newBalance);
}
