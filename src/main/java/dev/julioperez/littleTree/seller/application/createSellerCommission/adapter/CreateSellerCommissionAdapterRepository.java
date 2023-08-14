package dev.julioperez.littleTree.seller.application.createSellerCommission.adapter;

import dev.julioperez.littleTree.seller.domain.dto.CreateSellerCommissionRequest;
import dev.julioperez.littleTree.seller.domain.model.SellerCommission;
import dev.julioperez.littleTree.seller.domain.port.createSellerCommission.CreateSellerCommissionOutputPort;
import dev.julioperez.littleTree.seller.domain.port.mapper.SellerCommissionMapper;
import dev.julioperez.littleTree.seller.infrastructure.repository.dao.SellerCommissionDao;
import dev.julioperez.littleTree.seller.infrastructure.repository.entity.SellerCommissionEntity;

public class CreateSellerCommissionAdapterRepository implements CreateSellerCommissionOutputPort {
    private final SellerCommissionDao sellerCommissionDao;
    private final SellerCommissionMapper sellerCommissionMapper;

    public CreateSellerCommissionAdapterRepository(SellerCommissionDao sellerCommissionDao, SellerCommissionMapper sellerCommissionMapper) {
        this.sellerCommissionDao = sellerCommissionDao;
        this.sellerCommissionMapper = sellerCommissionMapper;
    }


    @Override
    public SellerCommission createSellerCommission(SellerCommission sellerCommission) {
        SellerCommissionEntity sellerCommissionEntity = sellerCommissionMapper.toSellerCommissionEntity(sellerCommission);
        sellerCommissionDao.save(sellerCommissionEntity);
        return sellerCommissionMapper.toSellerCommissionModel(sellerCommissionEntity);
    }
}
