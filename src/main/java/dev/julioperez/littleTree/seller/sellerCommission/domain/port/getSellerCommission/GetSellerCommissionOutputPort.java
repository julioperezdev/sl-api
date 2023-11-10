package dev.julioperez.littleTree.seller.sellerCommission.domain.port.getSellerCommission;

import dev.julioperez.littleTree.seller.sellerCommission.domain.model.SellerCommission;

import java.util.List;

public interface GetSellerCommissionOutputPort {
    List<SellerCommission> getSellerCommission();
}
