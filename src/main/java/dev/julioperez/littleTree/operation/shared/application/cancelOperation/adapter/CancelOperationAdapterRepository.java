package dev.julioperez.littleTree.operation.shared.application.cancelOperation.adapter;

import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;
import dev.julioperez.littleTree.operation.shared.domain.port.cancelOperation.CancelOperationOutputPort;
import dev.julioperez.littleTree.operation.buyOperation.domain.port.mapper.BuyOperationMapper;
import dev.julioperez.littleTree.operation.sellOperation.domain.port.mapper.SellOperationMapper;
import dev.julioperez.littleTree.operation.buyOperation.infrastructure.repository.dao.BuyOperationDao;
import dev.julioperez.littleTree.operation.sellOperation.infrastructure.repository.dao.SellOperationDao;
import dev.julioperez.littleTree.operation.buyOperation.infrastructure.repository.entity.BuyOperationEntity;
import dev.julioperez.littleTree.operation.sellOperation.infrastructure.repository.entity.SellOperationEntity;

public class CancelOperationAdapterRepository implements CancelOperationOutputPort {
    private final BuyOperationDao buyOperationDao;
    private final SellOperationDao sellOperationDao;
    private final BuyOperationMapper buyOperationMapper;
    private final SellOperationMapper sellOperationMapper;


    public CancelOperationAdapterRepository(BuyOperationDao buyOperationDao, SellOperationDao sellOperationDao, BuyOperationMapper buyOperationMapper, SellOperationMapper sellOperationMapper) {
        this.buyOperationDao = buyOperationDao;
        this.sellOperationDao = sellOperationDao;
        this.buyOperationMapper = buyOperationMapper;
        this.sellOperationMapper = sellOperationMapper;
    }

    public BuyOperation updateBuyOperation(BuyOperation buyOperation) {
        BuyOperationEntity buyOperationEntity = buyOperationMapper.toBuyOperationEntity(buyOperation);
        buyOperationDao.save(buyOperationEntity);
        return buyOperationMapper.toBuyOperationModel(buyOperationEntity);
    }

    public SellOperation updateSellOperations(SellOperation sellOperation) {
        SellOperationEntity sellOperationEntity = sellOperationMapper.toSellOperationEntity(sellOperation);
        sellOperationDao.save(sellOperationEntity);
        return sellOperationMapper.toSellOperationModel(sellOperationEntity);
    }
}
