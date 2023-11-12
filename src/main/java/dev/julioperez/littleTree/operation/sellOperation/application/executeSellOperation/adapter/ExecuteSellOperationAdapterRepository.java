package dev.julioperez.littleTree.operation.sellOperation.application.executeSellOperation.adapter;

import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.port.executeSellOperation.ExecuteSellOperationOutputPort;
import dev.julioperez.littleTree.operation.sellOperation.domain.port.mapper.SellOperationMapper;
import dev.julioperez.littleTree.operation.sellOperation.infrastructure.repository.dao.SellOperationDao;
import dev.julioperez.littleTree.operation.sellOperation.infrastructure.repository.entity.SellOperationEntity;

public class ExecuteSellOperationAdapterRepository implements ExecuteSellOperationOutputPort {
    private final SellOperationDao sellOperationDao;
    private final SellOperationMapper sellOperationMapper;

    public ExecuteSellOperationAdapterRepository(SellOperationDao sellOperationDao, SellOperationMapper sellOperationMapper) {
        this.sellOperationDao = sellOperationDao;
        this.sellOperationMapper = sellOperationMapper;
    }

    @Override
    public SellOperation updateSellOperations(SellOperation sellOperation) {
        SellOperationEntity sellOperationEntity = sellOperationMapper.toSellOperationEntity(sellOperation);
        sellOperationDao.save(sellOperationEntity);
        return sellOperationMapper.toSellOperationModel(sellOperationEntity);
    }
}
