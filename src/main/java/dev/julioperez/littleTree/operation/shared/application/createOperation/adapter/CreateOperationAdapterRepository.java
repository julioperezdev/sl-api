package dev.julioperez.littleTree.operation.shared.application.createOperation.adapter;

import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;
import dev.julioperez.littleTree.operation.shared.domain.port.createOperation.CreateOperationOutputPort;
import dev.julioperez.littleTree.operation.buyOperation.domain.port.mapper.BuyOperationMapper;
import dev.julioperez.littleTree.operation.sellOperation.domain.port.mapper.SellOperationMapper;
import dev.julioperez.littleTree.operation.buyOperation.infrastructure.repository.dao.BuyOperationDao;
import dev.julioperez.littleTree.operation.sellOperation.infrastructure.repository.dao.SellOperationDao;
import dev.julioperez.littleTree.operation.buyOperation.infrastructure.repository.entity.BuyOperationEntity;
import dev.julioperez.littleTree.operation.sellOperation.infrastructure.repository.entity.SellOperationEntity;

import java.util.List;

public class CreateOperationAdapterRepository implements CreateOperationOutputPort {
    private final BuyOperationDao buyOperationDao;
    private final SellOperationDao sellOperationDao;
    private final BuyOperationMapper buyOperationMapper;
    private final SellOperationMapper sellOperationMapper;

    public CreateOperationAdapterRepository(BuyOperationDao buyOperationDao, SellOperationDao sellOperationDao, BuyOperationMapper buyOperationMapper, SellOperationMapper sellOperationMapper) {
        this.buyOperationDao = buyOperationDao;
        this.sellOperationDao = sellOperationDao;
        this.buyOperationMapper = buyOperationMapper;
        this.sellOperationMapper = sellOperationMapper;
    }


    @Override
    public List<BuyOperation> saveBuyOperations(List<BuyOperation> buyOperations) {
        List<BuyOperationEntity> buyOperationsEntity = buyOperationMapper.toBuyOperationsEntity(buyOperations);
        buyOperationDao.saveAll(buyOperationsEntity);
        return buyOperationMapper.toBuyOperationsModel(buyOperationsEntity);
    }

    @Override
    public List<SellOperation> saveSellOperations(List<SellOperation> sellOperations) {
        List<SellOperationEntity> sellOperationsEntity = sellOperationMapper.toSellOperationsEntity(sellOperations);
        sellOperationDao.saveAll(sellOperationsEntity);
        return sellOperationMapper.toSellOperationsModel(sellOperationsEntity);
    }
}
