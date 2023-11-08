package dev.julioperez.littleTree.box.sellerbox.domain.port.manualTransactionSellerBox;

import dev.julioperez.littleTree.box.sellerbox.domain.dto.ManualTransactionSellerBoxRequest;

public interface ManualTransactionSellerBox {
    boolean execute(ManualTransactionSellerBoxRequest manualTransactionSellerBoxRequest);

}
