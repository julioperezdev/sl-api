package dev.julioperez.littleTree.box.sellerbox.application.saveSellerBox.service;

import dev.julioperez.littleTree.box.sellerbox.domain.model.SellerBox;
import dev.julioperez.littleTree.box.sellerbox.domain.port.saveSellerBox.SaveSellerBox;
import dev.julioperez.littleTree.box.sellerbox.domain.port.saveSellerBox.SaveSellerBoxOutputPort;

public class SaveSellerBoxService implements SaveSellerBox {
    private final SaveSellerBoxOutputPort saveSellerBoxOutputPort;

    public SaveSellerBoxService(SaveSellerBoxOutputPort saveSellerBoxOutputPort) {
        this.saveSellerBoxOutputPort = saveSellerBoxOutputPort;
    }

    @Override
    public SellerBox execute(SellerBox newSellerBox) {
        return saveSellerBoxOutputPort.saveOrUpdateSellerBox(newSellerBox);
    }
}
