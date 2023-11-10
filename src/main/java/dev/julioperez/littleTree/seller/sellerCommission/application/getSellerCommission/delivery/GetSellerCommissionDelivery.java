package dev.julioperez.littleTree.seller.sellerCommission.application.getSellerCommission.delivery;

import dev.julioperez.littleTree.seller.sellerCommission.domain.dto.SellerCommissionResponseDto;
import dev.julioperez.littleTree.seller.sellerCommission.domain.model.SellerCommission;
import dev.julioperez.littleTree.seller.sellerCommission.domain.port.getSellerCommission.GetSellerCommission;
import dev.julioperez.littleTree.seller.sellerCommission.domain.port.getSellerCommission.GetSellerCommissionInputPort;

import java.util.List;

public class GetSellerCommissionDelivery implements GetSellerCommissionInputPort {
    private final GetSellerCommission getSellerCommission;

    public GetSellerCommissionDelivery(GetSellerCommission getSellerCommission) {
        this.getSellerCommission = getSellerCommission;
    }

    @Override
    public List<SellerCommission> getSellerCommission() {
        return getSellerCommission.getSellerCommission();
    }

    @Override
    public List<SellerCommissionResponseDto> getPendingSellerCommission() {
        return getSellerCommission.getPendingSellerCommission();
    }

    @Override
    public List<SellerCommissionResponseDto> getDoneSellerCommission() {
        return getSellerCommission.getDoneSellerCommission();
    }
}
