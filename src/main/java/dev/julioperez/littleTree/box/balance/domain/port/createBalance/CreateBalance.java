package dev.julioperez.littleTree.box.balance.domain.port.createBalance;

import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;

public interface CreateBalance {
    boolean execute(SellOperation sellOperation);
}
