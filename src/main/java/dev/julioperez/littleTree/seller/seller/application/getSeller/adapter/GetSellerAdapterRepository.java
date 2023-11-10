package dev.julioperez.littleTree.seller.seller.application.getSeller.adapter;

import dev.julioperez.littleTree.seller.seller.domain.model.Seller;
import dev.julioperez.littleTree.seller.seller.domain.port.getSeller.GetSellerOutputPort;
import dev.julioperez.littleTree.seller.seller.domain.port.mapper.SellerMapper;
import dev.julioperez.littleTree.seller.seller.infrastructure.repository.dao.SellerDao;
import dev.julioperez.littleTree.seller.seller.infrastructure.repository.entity.SellerEntity;

import java.util.Collections;
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

    @Override
    public List<Seller> getSellersByIds(List<String> id) {
        List<SellerEntity> allById = sellerDao.findAllById(id);
        return allById.isEmpty()
                ? Collections.emptyList()
                : sellerMapper.toSellersModel(allById);
    }
}
