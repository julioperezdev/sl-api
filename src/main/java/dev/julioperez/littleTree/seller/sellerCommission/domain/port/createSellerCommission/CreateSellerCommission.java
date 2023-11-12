package dev.julioperez.littleTree.seller.sellerCommission.domain.port.createSellerCommission;

import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;
import dev.julioperez.littleTree.seller.sellerCommission.domain.model.SellerCommission;

public interface CreateSellerCommission {
    SellerCommission createSellerCommission(SellOperation sellOperation);
}
