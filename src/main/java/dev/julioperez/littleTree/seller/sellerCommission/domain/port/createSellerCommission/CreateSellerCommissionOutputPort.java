package dev.julioperez.littleTree.seller.sellerCommission.domain.port.createSellerCommission;

import dev.julioperez.littleTree.seller.sellerCommission.domain.model.SellerCommission;

public interface CreateSellerCommissionOutputPort {
    SellerCommission createSellerCommission(SellerCommission sellerCommission);
}
