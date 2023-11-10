package dev.julioperez.littleTree.seller.seller.domain.port.updateSeller;

import dev.julioperez.littleTree.seller.seller.domain.model.Seller;

public interface UpdateSellerOutputPort {
    Seller updateSeller(Seller seller);
}
