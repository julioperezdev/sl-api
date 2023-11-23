package dev.julioperez.littleTree.box.sellerbox.domain.port.getSellerBox;

import dev.julioperez.littleTree.box.balance.domain.dto.AssignSellerBoxRequest;
import dev.julioperez.littleTree.box.sellerbox.domain.model.SellerBox;

import java.util.List;
import java.util.Optional;

public interface GetSellerBox {
    List<SellerBox> getSellerBox();
    SellerBox getLastSellerBoxByName(String name);
    List<SellerBox> getSellerBoxByNameOrdered(String name);
}
