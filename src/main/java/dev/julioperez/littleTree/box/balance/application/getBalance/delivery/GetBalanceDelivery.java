package dev.julioperez.littleTree.box.balance.application.getBalance.delivery;

import dev.julioperez.littleTree.box.balance.domain.model.Balance;
import dev.julioperez.littleTree.box.balance.domain.port.getBalance.GetBalance;
import dev.julioperez.littleTree.box.balance.domain.port.getBalance.GetBalanceInputPort;

import java.util.List;

public class GetBalanceDelivery implements GetBalanceInputPort {
    private final GetBalance getBalance;

    public GetBalanceDelivery(GetBalance getBalance) {
        this.getBalance = getBalance;
    }

    @Override
    public List<Balance> getBalanceOrdered() {
        return getBalance.getBalanceOrdered();
    }
}
