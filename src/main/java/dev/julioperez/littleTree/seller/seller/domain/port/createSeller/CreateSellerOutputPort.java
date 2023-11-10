package dev.julioperez.littleTree.seller.seller.domain.port.createSeller;

import dev.julioperez.littleTree.seller.seller.domain.model.Seller;

public interface CreateSellerOutputPort {

    Seller createSeller(Seller seller);
}
