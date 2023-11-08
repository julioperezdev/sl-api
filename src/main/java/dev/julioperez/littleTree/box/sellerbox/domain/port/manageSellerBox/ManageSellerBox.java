package dev.julioperez.littleTree.box.sellerbox.domain.port.manageSellerBox;

import dev.julioperez.littleTree.box.balance.domain.dto.AssignSellerBoxRequest;
import dev.julioperez.littleTree.box.balance.domain.model.BalanceId;
import dev.julioperez.littleTree.box.sellerbox.domain.model.SellerBox;

import java.util.List;

public interface ManageSellerBox {

    SellerBox saveSellerBox(SellerBox newSellerBox);
    SellerBox getLastSellerBoxByName(String name);
    List<SellerBox> getSellerBoxByNameOrdered(String name);
    Boolean assignSellerBox(AssignSellerBoxRequest assignSellerBoxRequest);
}
