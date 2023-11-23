package dev.julioperez.littleTree.box.sellerbox.application.saveSellerBox.adapter;

import dev.julioperez.littleTree.box.sellerbox.domain.model.SellerBox;
import dev.julioperez.littleTree.box.sellerbox.domain.port.mapper.SellerBoxMapper;
import dev.julioperez.littleTree.box.sellerbox.domain.port.saveSellerBox.SaveSellerBoxOutputPort;
import dev.julioperez.littleTree.box.sellerbox.infrastructure.repository.dao.SellerBoxDao;
import dev.julioperez.littleTree.box.sellerbox.infrastructure.repository.entity.SellerBoxEntity;

public class SaveSellerBoxAdapterRepository implements SaveSellerBoxOutputPort {
    private final SellerBoxDao sellerBoxDao;
    private final SellerBoxMapper sellerBoxMapper;

    public SaveSellerBoxAdapterRepository(SellerBoxDao sellerBoxDao, SellerBoxMapper sellerBoxMapper) {
        this.sellerBoxDao = sellerBoxDao;
        this.sellerBoxMapper = sellerBoxMapper;
    }

    @Override
    public SellerBox saveOrUpdateSellerBox(SellerBox sellerBox) {
        SellerBoxEntity sellerBoxEntity = sellerBoxMapper.toSellerBoxEntity(sellerBox);
        sellerBoxDao.save(sellerBoxEntity);
        return sellerBoxMapper.toSellerBoxModel(sellerBoxEntity);
    }
}
