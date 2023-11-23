package dev.julioperez.littleTree.box.sellerbox.domain.port.saveSellerBox;

import dev.julioperez.littleTree.box.sellerbox.domain.model.SellerBox;

public interface SaveSellerBox {
    SellerBox execute(SellerBox newSellerBox);
}
