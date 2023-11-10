package dev.julioperez.littleTree.seller.sellerCommission.application.updateSellerCommission.service;

import dev.julioperez.littleTree.seller.sellerCommission.domain.dto.UpdateSellerCommissionRequest;
import dev.julioperez.littleTree.seller.sellerCommission.domain.model.SellerCommission;
import dev.julioperez.littleTree.seller.sellerCommission.domain.port.getSellerCommission.GetSellerCommission;
import dev.julioperez.littleTree.seller.sellerCommission.domain.port.mapper.SellerCommissionMapper;
import dev.julioperez.littleTree.seller.sellerCommission.domain.port.updateSellerCommission.UpdateSellerCommission;
import dev.julioperez.littleTree.seller.sellerCommission.domain.port.updateSellerCommission.UpdateSellerCommissionOutputPort;

import java.util.Optional;

public class UpdateSellerCommissionService implements UpdateSellerCommission {
    private final UpdateSellerCommissionOutputPort updateSellerCommissionOutputPort;
    private final GetSellerCommission getSellerCommission;
    private final SellerCommissionMapper sellerCommissionMapper;

    public UpdateSellerCommissionService(UpdateSellerCommissionOutputPort updateSellerCommissionOutputPort, GetSellerCommission getSellerCommission, SellerCommissionMapper sellerCommissionMapper) {
        this.updateSellerCommissionOutputPort = updateSellerCommissionOutputPort;
        this.getSellerCommission = getSellerCommission;
        this.sellerCommissionMapper = sellerCommissionMapper;
    }

    @Override
    public SellerCommission updateSellerCommission(UpdateSellerCommissionRequest updateSellerCommissionRequest) {
        Optional<SellerCommission> sellerCommissionById = getSellerCommission.getSellerCommissionById(updateSellerCommissionRequest.id());
        if(sellerCommissionById.isEmpty()) throw new IllegalArgumentException(String.format("%s value dont exist as SellerCommission", updateSellerCommissionRequest.id()));
        SellerCommission sellerCommission = sellerCommissionMapper.toSellerCommissionModel(sellerCommissionById.get(), updateSellerCommissionRequest);
        return updateSellerCommissionOutputPort.updateSellerCommission(sellerCommission);
    }
}
