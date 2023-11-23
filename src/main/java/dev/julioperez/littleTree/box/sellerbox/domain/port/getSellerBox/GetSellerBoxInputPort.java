package dev.julioperez.littleTree.box.sellerbox.domain.port.getSellerBox;

import dev.julioperez.littleTree.box.sellerbox.domain.model.SellerBox;

import java.util.List;

public interface GetSellerBoxInputPort {
    List<SellerBox> getSellerBoxByNameOrdered(String name);
}
