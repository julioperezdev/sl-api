package dev.julioperez.littleTree.seller.sellerCommission.domain.port.updateSellerCommission;

import dev.julioperez.littleTree.seller.sellerCommission.domain.dto.UpdateSellerCommissionRequest;
import dev.julioperez.littleTree.seller.sellerCommission.domain.model.SellerCommission;

public interface UpdateSellerCommission {
    SellerCommission updateSellerCommission(UpdateSellerCommissionRequest updateSellerCommissionRequest);
}
