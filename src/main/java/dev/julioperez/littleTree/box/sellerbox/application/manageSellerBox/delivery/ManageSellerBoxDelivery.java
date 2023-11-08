package dev.julioperez.littleTree.box.sellerbox.application.manageSellerBox.delivery;

import dev.julioperez.littleTree.box.balance.domain.dto.AssignSellerBoxRequest;
import dev.julioperez.littleTree.box.sellerbox.domain.model.SellerBox;
import dev.julioperez.littleTree.box.sellerbox.domain.port.manageSellerBox.ManageSellerBox;
import dev.julioperez.littleTree.box.sellerbox.domain.port.manageSellerBox.ManageSellerBoxInputPort;

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

    @Override
    public Boolean assignSellerBox(AssignSellerBoxRequest assignSellerBoxRequest) {
        return manageSellerBox.assignSellerBox(assignSellerBoxRequest);
    }
}
