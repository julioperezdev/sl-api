package dev.julioperez.littleTree.operation.application.executeSellOperation.adapter;

import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperation;
import dev.julioperez.littleTree.operation.domain.port.executeSellOperation.ExecuteSellOperationOutputPort;
import dev.julioperez.littleTree.operation.domain.port.mapper.SellOperationMapper;
import dev.julioperez.littleTree.operation.infrastructure.repository.dao.SellOperationDao;
import dev.julioperez.littleTree.operation.infrastructure.repository.entity.SellOperationEntity;

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
