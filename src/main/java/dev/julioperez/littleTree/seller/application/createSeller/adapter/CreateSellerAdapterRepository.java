package dev.julioperez.littleTree.seller.application.createSeller.adapter;

import dev.julioperez.littleTree.seller.domain.model.Seller;
import dev.julioperez.littleTree.seller.domain.port.createSeller.CreateSellerOutputPort;
import dev.julioperez.littleTree.seller.domain.port.mapper.SellerMapper;
import dev.julioperez.littleTree.seller.infrastructure.repository.dao.SellerDao;
import dev.julioperez.littleTree.seller.infrastructure.repository.entity.SellerEntity;

public class CreateSellerAdapterRepository implements CreateSellerOutputPort {
    private final SellerDao sellerDao;
    private final SellerMapper sellerMapper;

    public CreateSellerAdapterRepository(SellerDao sellerDao, SellerMapper sellerMapper) {
        this.sellerDao = sellerDao;
        this.sellerMapper = sellerMapper;
    }

    @Override
    public Seller createSeller(Seller seller) {
        SellerEntity sellerEntity = sellerMapper.toSellerEntity(seller);
        sellerDao.save(sellerEntity);
        return sellerMapper.toSellerModel(sellerEntity);
    }
}
