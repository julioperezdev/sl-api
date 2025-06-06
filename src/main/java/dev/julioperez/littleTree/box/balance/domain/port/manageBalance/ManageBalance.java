package dev.julioperez.littleTree.box.balance.domain.port.manageBalance;

import dev.julioperez.littleTree.box.balance.domain.model.Balance;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;

import java.util.List;

public interface ManageBalance {
    boolean createBalance(SellOperation sellOperation);
    List<Balance> getBalanceOrdered();
    Balance getLastBalance();

}
