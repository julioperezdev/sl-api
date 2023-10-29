package dev.julioperez.littleTree.box.domain.port.manageBalance;

import dev.julioperez.littleTree.box.domain.model.Balance;

import java.util.List;

public interface ManageBalanceInputPort{
    List<Balance> getBalanceOrdered();
}
