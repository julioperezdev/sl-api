package dev.julioperez.littleTree.box.application.manageBalance.delivery;

import dev.julioperez.littleTree.box.domain.model.Balance;
import dev.julioperez.littleTree.box.domain.port.manageBalance.ManageBalance;
import dev.julioperez.littleTree.box.domain.port.manageBalance.ManageBalanceInputPort;

import java.util.List;

public class ManageBalanceDelivery implements ManageBalanceInputPort {
    public ManageBalanceDelivery(ManageBalance manageBalance) {
        this.manageBalance = manageBalance;
    }

    private final ManageBalance manageBalance;
    @Override
    public List<Balance> getBalanceOrdered() {
        return manageBalance.getBalanceOrdered();
    }
}
