package dev.julioperez.littleTree.seller.sellerCommission.domain.port.createSellerCommission;

import dev.julioperez.littleTree.seller.sellerCommission.domain.dto.CreateSellerCommissionRequest;
import dev.julioperez.littleTree.seller.sellerCommission.domain.model.SellerCommission;

public interface CreateSellerCommissionInputPort {
    SellerCommission createSellerCommission(CreateSellerCommissionRequest createSellerCommissionRequest);
}
