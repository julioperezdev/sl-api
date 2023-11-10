package dev.julioperez.littleTree.seller.domain.port.getSellerCommission;

import dev.julioperez.littleTree.seller.domain.dto.SellerCommissionResponseDto;
import dev.julioperez.littleTree.seller.domain.model.SellerCommission;

import java.util.List;
import java.util.Optional;

public interface GetSellerCommission {
    List<SellerCommission> getSellerCommission();
    Optional<SellerCommission> getSellerCommissionById(String id);
    Optional<SellerCommission> getLastSellerCommissionBySellerId(String sellerId);
    List<SellerCommissionResponseDto> getPendingSellerCommission();
    List<SellerCommissionResponseDto> getDoneSellerCommission();
}
