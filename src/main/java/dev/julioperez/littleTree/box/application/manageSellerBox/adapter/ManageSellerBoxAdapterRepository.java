package dev.julioperez.littleTree.box.application.manageSellerBox.adapter;

import dev.julioperez.littleTree.box.domain.model.SellerBox;
import dev.julioperez.littleTree.box.domain.port.manageSellerBox.ManageSellerBoxOutputPort;
import dev.julioperez.littleTree.box.domain.port.mapper.SellerBoxMapper;
import dev.julioperez.littleTree.box.infrastructure.repository.dao.SellerBoxDao;
import dev.julioperez.littleTree.box.infrastructure.repository.entity.SellerBoxEntity;

import java.util.List;

public class ManageSellerBoxAdapterRepository implements ManageSellerBoxOutputPort {

    private final SellerBoxDao sellerBoxDao;
    private final SellerBoxMapper sellerBoxMapper;

    public ManageSellerBoxAdapterRepository(SellerBoxDao sellerBoxDao, SellerBoxMapper sellerBoxMapper) {
        this.sellerBoxDao = sellerBoxDao;
        this.sellerBoxMapper = sellerBoxMapper;
    }

    public SellerBox saveOrUpdateSellerBox(SellerBox sellerBox){
        SellerBoxEntity sellerBoxEntity = sellerBoxMapper.toSellerBoxEntity(sellerBox);
        sellerBoxDao.save(sellerBoxEntity);
        return sellerBoxMapper.toSellerBoxModel(sellerBoxEntity);
    }

    public List<SellerBox> getSellerBox(){
        List<SellerBoxEntity> sellerBoxEntities = sellerBoxDao.findAll();
        return sellerBoxMapper.toSellerBoxesModel(sellerBoxEntities);
    }
}
