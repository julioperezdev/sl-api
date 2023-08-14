package dev.julioperez.littleTree.seller.application.getSeller.adapter;

import dev.julioperez.littleTree.seller.domain.model.Seller;
import dev.julioperez.littleTree.seller.domain.port.getSeller.GetSellerOutputPort;
import dev.julioperez.littleTree.seller.domain.port.mapper.SellerMapper;
import dev.julioperez.littleTree.seller.infrastructure.repository.dao.SellerDao;
import dev.julioperez.littleTree.seller.infrastructure.repository.entity.SellerEntity;

import java.util.List;

public class GetSellerAdapterRepository implements GetSellerOutputPort {
    private final SellerDao sellerDao;
    private final SellerMapper sellerMapper;

    public GetSellerAdapterRepository(SellerDao sellerDao, SellerMapper sellerMapper) {
        this.sellerDao = sellerDao;
        this.sellerMapper = sellerMapper;
    }

    @Override
    public List<Seller> getSellers() {
        List<SellerEntity> sellerEntities = sellerDao.findAll();
        return sellerMapper.toSellersModel(sellerEntities);
    }
}
