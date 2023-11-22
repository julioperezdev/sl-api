package dev.julioperez.littleTree.operation.buyOperation.application.updateBuyOperation.adapter;

import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.buyOperation.domain.port.mapper.BuyOperationMapper;
import dev.julioperez.littleTree.operation.buyOperation.domain.port.updateBuyOperation.UpdateBuyOperationOutputPort;
import dev.julioperez.littleTree.operation.buyOperation.infrastructure.repository.dao.BuyOperationDao;
import dev.julioperez.littleTree.operation.buyOperation.infrastructure.repository.entity.BuyOperationEntity;

import java.util.List;

public class UpdateBuyOperationAdapterRepository implements UpdateBuyOperationOutputPort {
    private final BuyOperationDao buyOperationDao;
    private final BuyOperationMapper buyOperationMapper;

    public UpdateBuyOperationAdapterRepository(BuyOperationDao buyOperationDao, BuyOperationMapper buyOperationMapper) {
        this.buyOperationDao = buyOperationDao;
        this.buyOperationMapper = buyOperationMapper;
    }

    @Override
    public List<BuyOperation> updateBuyOperations(List<BuyOperation> buyOperations) {
        List<BuyOperationEntity> buyOperationsEntity = buyOperationMapper.toBuyOperationsEntity(buyOperations);
        buyOperationDao.saveAll(buyOperationsEntity);
        return buyOperationMapper.toBuyOperationsModel(buyOperationsEntity);
    }
}
