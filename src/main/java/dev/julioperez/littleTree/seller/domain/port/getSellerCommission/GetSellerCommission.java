package dev.julioperez.littleTree.seller.domain.port.getSellerCommission;

import dev.julioperez.littleTree.seller.domain.model.SellerCommission;

import java.util.List;
import java.util.Optional;

public interface GetSellerCommission {
    List<SellerCommission> getSellerCommission();
    Optional<SellerCommission> getSellerCommissionById(String id);
}
