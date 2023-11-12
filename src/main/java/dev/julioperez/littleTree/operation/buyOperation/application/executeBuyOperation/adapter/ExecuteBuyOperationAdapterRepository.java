package dev.julioperez.littleTree.operation.buyOperation.application.executeBuyOperation.adapter;

import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.buyOperation.domain.port.executeBuyOperation.ExecuteBuyOperationOutputPort;
import dev.julioperez.littleTree.operation.buyOperation.domain.port.mapper.BuyOperationMapper;
import dev.julioperez.littleTree.operation.buyOperation.infrastructure.repository.dao.BuyOperationDao;
import dev.julioperez.littleTree.operation.buyOperation.infrastructure.repository.entity.BuyOperationEntity;

public class ExecuteBuyOperationAdapterRepository implements ExecuteBuyOperationOutputPort {
    private final BuyOperationDao buyOperationDao;
    private final BuyOperationMapper buyOperationMapper;

    public ExecuteBuyOperationAdapterRepository(BuyOperationDao buyOperationDao, BuyOperationMapper buyOperationMapper) {
        this.buyOperationDao = buyOperationDao;
        this.buyOperationMapper = buyOperationMapper;
    }

    @Override
    public BuyOperation updateBuyOperation(BuyOperation buyOperation) {
        BuyOperationEntity buyOperationEntity = buyOperationMapper.toBuyOperationEntity(buyOperation);
        buyOperationDao.save(buyOperationEntity);
        return buyOperationMapper.toBuyOperationModel(buyOperationEntity);
    }
}
