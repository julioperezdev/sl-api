package dev.julioperez.littleTree.box.domain.port.manageSellerBox;

import dev.julioperez.littleTree.box.domain.model.SellerBox;

import java.util.List;

public interface ManageSellerBoxOutputPort {

    SellerBox saveOrUpdateSellerBox(SellerBox sellerBox);
    List<SellerBox> getSellerBox();

}
