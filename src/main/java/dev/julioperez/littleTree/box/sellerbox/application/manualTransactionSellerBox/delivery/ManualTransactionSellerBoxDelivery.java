package dev.julioperez.littleTree.box.sellerbox.application.manualTransactionSellerBox.delivery;

import dev.julioperez.littleTree.box.sellerbox.domain.dto.ManualTransactionSellerBoxRequest;
import dev.julioperez.littleTree.box.sellerbox.domain.port.manualTransactionSellerBox.ManualTransactionSellerBox;
import dev.julioperez.littleTree.box.sellerbox.domain.port.manualTransactionSellerBox.ManualTransactionSellerBoxInputPort;

public class ManualTransactionSellerBoxDelivery implements ManualTransactionSellerBoxInputPort {
   private final ManualTransactionSellerBox manualTransactionSellerBox;

    public ManualTransactionSellerBoxDelivery(ManualTransactionSellerBox manualTransactionSellerBox) {
        this.manualTransactionSellerBox = manualTransactionSellerBox;
    }

    public boolean manualTransactionSellerBox(ManualTransactionSellerBoxRequest manualTransactionSellerBoxRequest){
        return manualTransactionSellerBox.execute(manualTransactionSellerBoxRequest);
    }
}
