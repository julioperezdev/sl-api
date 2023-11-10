package dev.julioperez.littleTree.seller.sellerCommission.domain.port.updateSellerCommission;

import dev.julioperez.littleTree.seller.sellerCommission.domain.model.SellerCommission;

public interface UpdateSellerCommissionOutputPort {
    SellerCommission updateSellerCommission(SellerCommission sellerCommission);
}
