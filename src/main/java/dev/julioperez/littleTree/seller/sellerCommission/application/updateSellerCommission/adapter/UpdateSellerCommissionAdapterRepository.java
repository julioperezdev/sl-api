package dev.julioperez.littleTree.seller.sellerCommission.application.updateSellerCommission.adapter;

import dev.julioperez.littleTree.seller.sellerCommission.domain.model.SellerCommission;
import dev.julioperez.littleTree.seller.sellerCommission.domain.port.mapper.SellerCommissionMapper;
import dev.julioperez.littleTree.seller.sellerCommission.domain.port.updateSellerCommission.UpdateSellerCommissionOutputPort;
import dev.julioperez.littleTree.seller.sellerCommission.infrastructure.repository.dao.SellerCommissionDao;
import dev.julioperez.littleTree.seller.sellerCommission.infrastructure.repository.entity.SellerCommissionEntity;

public class UpdateSellerCommissionAdapterRepository implements UpdateSellerCommissionOutputPort {
    private final SellerCommissionDao sellerCommissionDao;
    private final SellerCommissionMapper sellerCommissionMapper;

    public UpdateSellerCommissionAdapterRepository(SellerCommissionDao sellerCommissionDao, SellerCommissionMapper sellerCommissionMapper) {
        this.sellerCommissionDao = sellerCommissionDao;
        this.sellerCommissionMapper = sellerCommissionMapper;
    }

    @Override
    public SellerCommission updateSellerCommission(SellerCommission sellerCommission) {
        SellerCommissionEntity sellerCommissionEntity = sellerCommissionMapper.toSellerCommissionEntity(sellerCommission);
        sellerCommissionDao.save(sellerCommissionEntity);
        return sellerCommissionMapper.toSellerCommissionModel(sellerCommissionEntity);
    }
}
