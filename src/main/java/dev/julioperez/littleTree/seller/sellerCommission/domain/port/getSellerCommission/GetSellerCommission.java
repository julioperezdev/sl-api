package dev.julioperez.littleTree.seller.sellerCommission.domain.port.getSellerCommission;

import dev.julioperez.littleTree.seller.sellerCommission.domain.dto.SellerCommissionResponseDto;
import dev.julioperez.littleTree.seller.sellerCommission.domain.model.SellerCommission;

import java.util.List;
import java.util.Optional;

public interface GetSellerCommission {
    List<SellerCommission> getSellerCommission();
    Optional<SellerCommission> getSellerCommissionById(String id);
    Optional<SellerCommission> getLastSellerCommissionBySellerId(String sellerId);
    List<SellerCommissionResponseDto> getPendingSellerCommission();
    List<SellerCommissionResponseDto> getDoneSellerCommission();
}
