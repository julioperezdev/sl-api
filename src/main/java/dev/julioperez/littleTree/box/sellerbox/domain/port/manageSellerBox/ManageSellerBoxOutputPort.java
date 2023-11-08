package dev.julioperez.littleTree.box.sellerbox.domain.port.manageSellerBox;

import dev.julioperez.littleTree.box.sellerbox.domain.enums.SellerBoxNames;
import dev.julioperez.littleTree.box.sellerbox.domain.model.SellerBox;

import java.util.List;
import java.util.Optional;

public interface ManageSellerBoxOutputPort {

    SellerBox saveOrUpdateSellerBox(SellerBox sellerBox);
    List<SellerBox> getSellerBox();
    SellerBox getLastSellerBoxByName(SellerBoxNames name);

}
