package dev.julioperez.littleTree.seller.domain.port.updateSellerCommission;

import dev.julioperez.littleTree.seller.domain.dto.UpdateSellerCommissionRequest;
import dev.julioperez.littleTree.seller.domain.model.SellerCommission;

public interface UpdateSellerCommissionInputPort {
    SellerCommission updateSellerCommission(UpdateSellerCommissionRequest updateSellerCommissionRequest);
}
