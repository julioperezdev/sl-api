package dev.julioperez.littleTree.operation.application.getOperations.adapter;

import dev.julioperez.littleTree.operation.domain.model.buyOperation.BuyOperation;
import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperation;
import dev.julioperez.littleTree.operation.domain.port.getOperations.GetOperationsOutputPort;
import dev.julioperez.littleTree.operation.domain.port.mapper.BuyOperationMapper;
import dev.julioperez.littleTree.operation.domain.port.mapper.SellOperationMapper;
import dev.julioperez.littleTree.operation.infrastructure.repository.dao.BuyOperationDao;
import dev.julioperez.littleTree.operation.infrastructure.repository.dao.SellOperationDao;
import dev.julioperez.littleTree.operation.infrastructure.repository.entity.BuyOperationEntity;
import dev.julioperez.littleTree.operation.infrastructure.repository.entity.SellOperationEntity;

import java.util.List;

public class GetOperationsAdapterRepository implements GetOperationsOutputPort {
    private final BuyOperationDao buyOperationDao;
    private final SellOperationDao sellOperationDao;
    private final BuyOperationMapper buyOperationMapper;
    private final SellOperationMapper sellOperationMapper;

    public GetOperationsAdapterRepository(BuyOperationDao buyOperationDao, SellOperationDao sellOperationDao, BuyOperationMapper buyOperationMapper, SellOperationMapper sellOperationMapper) {
        this.buyOperationDao = buyOperationDao;
        this.sellOperationDao = sellOperationDao;
        this.buyOperationMapper = buyOperationMapper;
        this.sellOperationMapper = sellOperationMapper;
    }

    @Override
    public List<BuyOperation> getBuyOperations() {
        List<BuyOperationEntity> buyOperationEntities = buyOperationDao.findAll();
        return buyOperationMapper.toBuyOperationsModel(buyOperationEntities);
    }

    @Override
    public List<SellOperation> getSellOperations() {
        List<SellOperationEntity> sellOperationEntities = sellOperationDao.findAll();
        return sellOperationMapper.toSellOperationsModel(sellOperationEntities);
    }
}
