package dev.julioperez.littleTree.box.sellerbox.domain.port.assignSellerBox;

import dev.julioperez.littleTree.box.balance.domain.dto.AssignSellerBoxRequest;

public interface AssignSellerBox {
    boolean execute(AssignSellerBoxRequest assignSellerBoxRequest);
}
