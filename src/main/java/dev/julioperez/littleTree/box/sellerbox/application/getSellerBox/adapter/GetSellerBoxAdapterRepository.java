package dev.julioperez.littleTree.box.sellerbox.application.getSellerBox.adapter;

import dev.julioperez.littleTree.box.sellerbox.domain.enums.SellerBoxNames;
import dev.julioperez.littleTree.box.sellerbox.domain.model.SellerBox;
import dev.julioperez.littleTree.box.sellerbox.domain.port.getSellerBox.GetSellerBoxOutputPort;
import dev.julioperez.littleTree.box.sellerbox.domain.port.mapper.SellerBoxMapper;
import dev.julioperez.littleTree.box.sellerbox.infrastructure.repository.dao.SellerBoxDao;
import dev.julioperez.littleTree.box.sellerbox.infrastructure.repository.entity.SellerBoxEntity;

import java.util.List;
import java.util.Optional;

public class GetSellerBoxAdapterRepository implements GetSellerBoxOutputPort {

    private final SellerBoxDao sellerBoxDao;
    private final SellerBoxMapper sellerBoxMapper;

    public GetSellerBoxAdapterRepository(SellerBoxDao sellerBoxDao, SellerBoxMapper sellerBoxMapper) {
        this.sellerBoxDao = sellerBoxDao;
        this.sellerBoxMapper = sellerBoxMapper;
    }

    @Override
    public List<SellerBox> getSellerBox() {
        List<SellerBoxEntity> sellerBoxEntities = sellerBoxDao.findAll();
        return sellerBoxMapper.toSellerBoxesModel(sellerBoxEntities);
    }

    @Override
    public SellerBox getLastSellerBoxByName(SellerBoxNames name) {
        Optional<SellerBoxEntity> optionalSellerBoxEntity = sellerBoxDao.getFirstByNameOrderByUpdatedAtDesc(name.value());
        return optionalSellerBoxEntity.map(sellerBoxMapper::toSellerBoxModel).orElse(null);
    }
}
