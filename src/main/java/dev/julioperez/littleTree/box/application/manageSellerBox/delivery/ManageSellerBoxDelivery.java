package dev.julioperez.littleTree.box.application.manageSellerBox.delivery;

import dev.julioperez.littleTree.box.domain.model.SellerBox;
import dev.julioperez.littleTree.box.domain.port.manageSellerBox.ManageSellerBox;
import dev.julioperez.littleTree.box.domain.port.manageSellerBox.ManageSellerBoxInputPort;

import java.util.List;

public class ManageSellerBoxDelivery implements ManageSellerBoxInputPort {
    private final ManageSellerBox manageSellerBox;

    public ManageSellerBoxDelivery(ManageSellerBox manageSellerBox) {
        this.manageSellerBox = manageSellerBox;
    }

    @Override
    public List<SellerBox> getSellerBoxByNameOrdered(String name) {
        return manageSellerBox.getSellerBoxByNameOrdered(name);
    }
}
