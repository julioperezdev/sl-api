package dev.julioperez.littleTree.seller.application.getSellerCommission.adapter;

import dev.julioperez.littleTree.seller.domain.model.SellerCommission;
import dev.julioperez.littleTree.seller.domain.port.getSellerCommission.GetSellerCommissionOutputPort;
import dev.julioperez.littleTree.seller.domain.port.mapper.SellerCommissionMapper;
import dev.julioperez.littleTree.seller.infrastructure.repository.dao.SellerCommissionDao;
import dev.julioperez.littleTree.seller.infrastructure.repository.entity.SellerCommissionEntity;

import java.util.Collections;
import java.util.List;

public class GetSellerCommissionAdapterRepository implements GetSellerCommissionOutputPort {
    private final SellerCommissionDao sellerCommissionDao;
    private final SellerCommissionMapper sellerCommissionMapper;

    public GetSellerCommissionAdapterRepository(SellerCommissionDao sellerCommissionDao, SellerCommissionMapper sellerCommissionMapper) {
        this.sellerCommissionDao = sellerCommissionDao;
        this.sellerCommissionMapper = sellerCommissionMapper;
    }

    @Override
    public List<SellerCommission> getSellerCommission() {
        List<SellerCommissionEntity> sellerCommissionEntities = sellerCommissionDao.findAll();
        return sellerCommissionEntities.isEmpty()
                ? Collections.emptyList()
                : sellerCommissionMapper.toSellerCommissionsModel(sellerCommissionEntities);
    }
}
