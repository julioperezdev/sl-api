package dev.julioperez.littleTree.box.balance.domain.port.manageBalance;

import dev.julioperez.littleTree.box.balance.domain.model.Balance;

import java.util.List;

public interface ManageBalanceInputPort{
    List<Balance> getBalanceOrdered();
}
