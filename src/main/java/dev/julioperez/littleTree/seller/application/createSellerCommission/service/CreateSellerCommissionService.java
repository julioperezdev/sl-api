package dev.julioperez.littleTree.seller.application.createSellerCommission.service;

import dev.julioperez.littleTree.seller.domain.dto.CreateSellerCommissionRequest;
import dev.julioperez.littleTree.seller.domain.model.SellerCommission;
import dev.julioperez.littleTree.seller.domain.port.createSellerCommission.CreateSellerCommission;
import dev.julioperez.littleTree.seller.domain.port.createSellerCommission.CreateSellerCommissionOutputPort;
import dev.julioperez.littleTree.seller.domain.port.mapper.SellerCommissionMapper;

public class CreateSellerCommissionService implements CreateSellerCommission {
    private final CreateSellerCommissionOutputPort createSellerCommissionOutputPort;
    private final SellerCommissionMapper sellerCommissionMapper;

    public CreateSellerCommissionService(CreateSellerCommissionOutputPort createSellerCommissionOutputPort, SellerCommissionMapper sellerCommissionMapper) {
        this.createSellerCommissionOutputPort = createSellerCommissionOutputPort;
        this.sellerCommissionMapper = sellerCommissionMapper;
    }

    @Override
    public SellerCommission createSellerCommission(CreateSellerCommissionRequest createSellerCommissionRequest) {
        SellerCommission sellerCommission = sellerCommissionMapper.toSellerCommissionModel(createSellerCommissionRequest);
        return createSellerCommissionOutputPort.createSellerCommission(sellerCommission);
    }
}
