package dev.julioperez.littleTree.seller.domain.port.updateSeller;

import dev.julioperez.littleTree.seller.domain.dto.UpdateSellerRequest;
import dev.julioperez.littleTree.seller.domain.model.Seller;

public interface UpdateSellerOutputPort {
    Seller updateSeller(Seller seller);
}
