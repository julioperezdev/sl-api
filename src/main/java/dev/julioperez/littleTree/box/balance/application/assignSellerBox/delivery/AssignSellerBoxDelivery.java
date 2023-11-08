package dev.julioperez.littleTree.box.balance.application.assignSellerBox.delivery;

import dev.julioperez.littleTree.box.balance.domain.dto.AssignSellerBoxRequest;
import dev.julioperez.littleTree.box.balance.domain.port.assignToSellerBox.AssignSellerBox;
import dev.julioperez.littleTree.box.balance.domain.port.assignToSellerBox.AssignSellerBoxInputPort;

public class AssignSellerBoxDelivery implements AssignSellerBoxInputPort {

    private final AssignSellerBox assignSellerBox;

    public AssignSellerBoxDelivery(AssignSellerBox assignSellerBox) {
        this.assignSellerBox = assignSellerBox;
    }

    @Override
    public boolean execute(AssignSellerBoxRequest assignSellerBoxRequest) {
        return assignSellerBox.execute(assignSellerBoxRequest);
    }
}
