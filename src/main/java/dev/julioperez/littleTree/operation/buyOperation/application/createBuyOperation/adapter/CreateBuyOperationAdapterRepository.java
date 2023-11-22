package dev.julioperez.littleTree.operation.buyOperation.application.createBuyOperation.adapter;

import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.buyOperation.domain.port.createBuyOperation.CreateBuyOperationOutputPort;
import dev.julioperez.littleTree.operation.buyOperation.domain.port.mapper.BuyOperationMapper;
import dev.julioperez.littleTree.operation.buyOperation.infrastructure.repository.dao.BuyOperationDao;
import dev.julioperez.littleTree.operation.buyOperation.infrastructure.repository.entity.BuyOperationEntity;

import java.util.List;

public class CreateBuyOperationAdapterRepository implements CreateBuyOperationOutputPort {
    private final BuyOperationDao buyOperationDao;
    private final BuyOperationMapper buyOperationMapper;

    public CreateBuyOperationAdapterRepository(BuyOperationDao buyOperationDao, BuyOperationMapper buyOperationMapper) {
        this.buyOperationDao = buyOperationDao;
        this.buyOperationMapper = buyOperationMapper;
    }

    @Override
    public List<BuyOperation> saveBuyOperations(List<BuyOperation> buyOperations) {
        List<BuyOperationEntity> buyOperationsEntity = buyOperationMapper.toBuyOperationsEntity(buyOperations);
        buyOperationDao.saveAll(buyOperationsEntity);
        return buyOperationMapper.toBuyOperationsModel(buyOperationsEntity);
    }
}
