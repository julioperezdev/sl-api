package dev.julioperez.littleTree.operation.sellOperation.application.createSellOperation.adapter;

import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.port.createSellOperation.CreateSellOperationOutputPort;
import dev.julioperez.littleTree.operation.sellOperation.domain.port.mapper.SellOperationMapper;
import dev.julioperez.littleTree.operation.sellOperation.infrastructure.repository.dao.SellOperationDao;
import dev.julioperez.littleTree.operation.sellOperation.infrastructure.repository.entity.SellOperationEntity;

import java.util.List;

public class CreateSellOperationAdapterRepository implements CreateSellOperationOutputPort {
    private final SellOperationDao sellOperationDao;
    private final SellOperationMapper sellOperationMapper;

    public CreateSellOperationAdapterRepository(SellOperationDao sellOperationDao, SellOperationMapper sellOperationMapper) {
        this.sellOperationDao = sellOperationDao;
        this.sellOperationMapper = sellOperationMapper;
    }

    @Override
    public List<SellOperation> saveSellOperations(List<SellOperation> sellOperations) {
        List<SellOperationEntity> sellOperationsEntity = sellOperationMapper.toSellOperationsEntity(sellOperations);
        sellOperationDao.saveAll(sellOperationsEntity);
        return sellOperationMapper.toSellOperationsModel(sellOperationsEntity);
    }
}
