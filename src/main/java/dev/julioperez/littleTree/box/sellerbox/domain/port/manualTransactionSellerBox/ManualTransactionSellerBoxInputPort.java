package dev.julioperez.littleTree.box.sellerbox.domain.port.manualTransactionSellerBox;

import dev.julioperez.littleTree.box.sellerbox.domain.dto.ManualTransactionSellerBoxRequest;

public interface ManualTransactionSellerBoxInputPort {
    boolean manualTransactionSellerBox(ManualTransactionSellerBoxRequest manualTransactionSellerBoxRequest);
}
