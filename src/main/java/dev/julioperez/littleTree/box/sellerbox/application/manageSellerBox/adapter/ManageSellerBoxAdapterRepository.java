package dev.julioperez.littleTree.box.sellerbox.application.manageSellerBox.adapter;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.currencyBox.shared.infrastructure.repository.entity.CurrencyMultiBoxEntity;
import dev.julioperez.littleTree.box.sellerbox.domain.enums.SellerBoxNames;
import dev.julioperez.littleTree.box.sellerbox.domain.model.SellerBox;
import dev.julioperez.littleTree.box.sellerbox.domain.port.manageSellerBox.ManageSellerBoxOutputPort;
import dev.julioperez.littleTree.box.sellerbox.domain.port.mapper.SellerBoxMapper;
import dev.julioperez.littleTree.box.sellerbox.infrastructure.repository.dao.SellerBoxDao;
import dev.julioperez.littleTree.box.sellerbox.infrastructure.repository.entity.SellerBoxEntity;

import java.util.List;
import java.util.Optional;

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

    public SellerBox getLastSellerBoxByName(SellerBoxNames name) {
        Optional<SellerBoxEntity> optionalSellerBoxEntity = sellerBoxDao.getFirstByNameOrderByUpdatedAtDesc(name.value());
        return optionalSellerBoxEntity.map(sellerBoxMapper::toSellerBoxModel).orElse(null);

    }
}
