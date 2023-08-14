package dev.julioperez.littleTree.seller.domain.port.createSellerCommission;

import dev.julioperez.littleTree.seller.domain.dto.CreateSellerCommissionRequest;
import dev.julioperez.littleTree.seller.domain.model.SellerCommission;

public interface CreateSellerCommission {
    SellerCommission createSellerCommission(CreateSellerCommissionRequest createSellerCommissionRequest);
}
