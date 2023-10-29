package dev.julioperez.littleTree.box.domain.port.manageSellerBox;

import dev.julioperez.littleTree.box.domain.model.SellerBox;

import java.util.List;

public interface ManageSellerBoxInputPort {

    List<SellerBox> getSellerBoxByNameOrdered(String name);
}
