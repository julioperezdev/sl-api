package dev.julioperez.littleTree.seller.seller.domain.port.updateSeller;

import dev.julioperez.littleTree.seller.seller.domain.dto.UpdateSellerRequest;
import dev.julioperez.littleTree.seller.seller.domain.model.Seller;

public interface UpdateSeller {
    Seller updateSeller(UpdateSellerRequest updateSellerRequest);
}
