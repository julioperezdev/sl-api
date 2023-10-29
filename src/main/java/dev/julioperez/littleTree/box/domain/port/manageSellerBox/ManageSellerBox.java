package dev.julioperez.littleTree.box.domain.port.manageSellerBox;

import dev.julioperez.littleTree.box.domain.model.BalanceId;
import dev.julioperez.littleTree.box.domain.model.SellerBox;

import java.util.List;

public interface ManageSellerBox {
    SellerBox asignSellerBox(BalanceId balanceId);
    List<SellerBox> getSellerBoxByNameOrdered(String name);
}
