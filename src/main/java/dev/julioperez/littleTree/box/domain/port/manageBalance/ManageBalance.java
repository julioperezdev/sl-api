package dev.julioperez.littleTree.box.domain.port.manageBalance;

import dev.julioperez.littleTree.box.domain.model.Balance;

public interface ManageBalance {
    boolean createBalance(Balance newBalance);
}
