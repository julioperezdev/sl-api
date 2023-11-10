package dev.julioperez.littleTree.seller.domain.port.getSellerCommission;

import dev.julioperez.littleTree.seller.domain.dto.SellerCommissionResponseDto;
import dev.julioperez.littleTree.seller.domain.model.SellerCommission;

import java.util.List;

public interface GetSellerCommissionInputPort {
    List<SellerCommission> getSellerCommission();

    List<SellerCommissionResponseDto> getPendingSellerCommission();
    List<SellerCommissionResponseDto> getDoneSellerCommission();
}
