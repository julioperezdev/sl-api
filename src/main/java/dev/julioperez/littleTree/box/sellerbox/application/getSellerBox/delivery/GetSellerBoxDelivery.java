package dev.julioperez.littleTree.box.sellerbox.application.getSellerBox.delivery;

import dev.julioperez.littleTree.box.sellerbox.domain.model.SellerBox;
import dev.julioperez.littleTree.box.sellerbox.domain.port.getSellerBox.GetSellerBox;
import dev.julioperez.littleTree.box.sellerbox.domain.port.getSellerBox.GetSellerBoxInputPort;

import java.util.List;

public class GetSellerBoxDelivery implements GetSellerBoxInputPort {
    private final GetSellerBox getSellerBox;

    public GetSellerBoxDelivery(GetSellerBox getSellerBox) {
        this.getSellerBox = getSellerBox;
    }

    @Override
    public List<SellerBox> getSellerBoxByNameOrdered(String name) {
        return getSellerBox.getSellerBoxByNameOrdered(name);
    }
}
