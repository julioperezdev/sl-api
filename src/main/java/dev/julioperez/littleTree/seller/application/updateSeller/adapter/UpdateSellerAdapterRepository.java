package dev.julioperez.littleTree.seller.application.updateSeller.adapter;

import dev.julioperez.littleTree.seller.domain.model.Seller;
import dev.julioperez.littleTree.seller.domain.port.mapper.SellerMapper;
import dev.julioperez.littleTree.seller.domain.port.updateSeller.UpdateSellerOutputPort;
import dev.julioperez.littleTree.seller.infrastructure.repository.dao.SellerDao;
import dev.julioperez.littleTree.seller.infrastructure.repository.entity.SellerEntity;

public class UpdateSellerAdapterRepository implements UpdateSellerOutputPort {
    private final SellerDao sellerDao;
    private final SellerMapper sellerMapper;

    public UpdateSellerAdapterRepository(SellerDao sellerDao, SellerMapper sellerMapper) {
        this.sellerDao = sellerDao;
        this.sellerMapper = sellerMapper;
    }

    @Override
    public Seller updateSeller(Seller seller) {
        SellerEntity sellerEntity = sellerMapper.toSellerEntity(seller);
        sellerDao.save(sellerEntity);
        return sellerMapper.toSellerModel(sellerEntity);
    }
}
