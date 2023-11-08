package dev.julioperez.littleTree.box.balance.domain.port.assignToSellerBox;

import dev.julioperez.littleTree.box.balance.domain.dto.AssignSellerBoxRequest;

public interface AssignSellerBoxInputPort {

    boolean execute(AssignSellerBoxRequest assignSellerBoxRequest);
}
