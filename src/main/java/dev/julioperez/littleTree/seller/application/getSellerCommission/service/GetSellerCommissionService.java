package dev.julioperez.littleTree.seller.application.getSellerCommission.service;

import dev.julioperez.littleTree.seller.domain.model.SellerCommission;
import dev.julioperez.littleTree.seller.domain.port.getSellerCommission.GetSellerCommission;
import dev.julioperez.littleTree.seller.domain.port.getSellerCommission.GetSellerCommissionOutputPort;

import java.util.List;
import java.util.Optional;

public class GetSellerCommissionService implements GetSellerCommission {
    private final GetSellerCommissionOutputPort getSellerCommissionOutputPort;

    public GetSellerCommissionService(GetSellerCommissionOutputPort getSellerCommissionOutputPort) {
        this.getSellerCommissionOutputPort = getSellerCommissionOutputPort;
    }

    @Override
    public List<SellerCommission> getSellerCommission() {
        return getSellerCommissionOutputPort.getSellerCommission();
    }

    @Override
    public Optional<SellerCommission> getSellerCommissionById(String id) {
        List<SellerCommission> sellerCommissions = getSellerCommission();
        return sellerCommissions.stream()
                .filter(sellerCommission -> sellerCommission.getId().equals(id))
                .findFirst();
    }
}
