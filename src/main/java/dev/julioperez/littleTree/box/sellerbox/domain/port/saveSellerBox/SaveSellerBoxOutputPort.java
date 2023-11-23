package dev.julioperez.littleTree.box.sellerbox.domain.port.saveSellerBox;

import dev.julioperez.littleTree.box.sellerbox.domain.model.SellerBox;

public interface SaveSellerBoxOutputPort {
    SellerBox saveOrUpdateSellerBox(SellerBox sellerBox);
}
