package dev.julioperez.littleTree.seller.domain.port.updateSellerCommission;

import dev.julioperez.littleTree.seller.domain.model.SellerCommission;

public interface UpdateSellerCommissionOutputPort {
    SellerCommission updateSellerCommission(SellerCommission sellerCommission);
}
