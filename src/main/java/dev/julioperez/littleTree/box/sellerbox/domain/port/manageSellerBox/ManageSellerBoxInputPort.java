package dev.julioperez.littleTree.box.sellerbox.domain.port.manageSellerBox;

import dev.julioperez.littleTree.box.balance.domain.dto.AssignSellerBoxRequest;
import dev.julioperez.littleTree.box.sellerbox.domain.model.SellerBox;

import java.util.List;

public interface ManageSellerBoxInputPort {

    List<SellerBox> getSellerBoxByNameOrdered(String name);
    Boolean assignSellerBox(AssignSellerBoxRequest assignSellerBoxRequest);
}
