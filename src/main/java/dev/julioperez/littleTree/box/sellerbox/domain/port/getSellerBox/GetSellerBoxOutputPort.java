package dev.julioperez.littleTree.box.sellerbox.domain.port.getSellerBox;

import dev.julioperez.littleTree.box.sellerbox.domain.enums.SellerBoxNames;
import dev.julioperez.littleTree.box.sellerbox.domain.model.SellerBox;

import java.util.List;

public interface GetSellerBoxOutputPort {
    List<SellerBox> getSellerBox();
    SellerBox getLastSellerBoxByName(SellerBoxNames name);
}
