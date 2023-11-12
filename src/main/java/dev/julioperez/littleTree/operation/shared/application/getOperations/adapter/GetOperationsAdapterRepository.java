package dev.julioperez.littleTree.operation.shared.application.getOperations.adapter;

import dev.julioperez.littleTree.operation.shared.domain.enums.OperationStatus;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;
import dev.julioperez.littleTree.operation.shared.domain.port.getOperations.GetOperationsOutputPort;
import dev.julioperez.littleTree.operation.buyOperation.domain.port.mapper.BuyOperationMapper;
import dev.julioperez.littleTree.operation.sellOperation.domain.port.mapper.SellOperationMapper;
import dev.julioperez.littleTree.operation.buyOperation.infrastructure.repository.dao.BuyOperationDao;
import dev.julioperez.littleTree.operation.sellOperation.infrastructure.repository.dao.SellOperationDao;
import dev.julioperez.littleTree.operation.buyOperation.infrastructure.repository.entity.BuyOperationEntity;
import dev.julioperez.littleTree.operation.sellOperation.infrastructure.repository.entity.SellOperationEntity;

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
    public List<BuyOperation> getBuyOperationsByStatus(OperationStatus operationStatus) {
        List<BuyOperationEntity> allPendingBuyOperation = buyOperationDao.getAllByOperationStatus(operationStatus.value());
        return buyOperationMapper.toBuyOperationsModel(allPendingBuyOperation);
    }

    @Override
    public List<SellOperation> geSellOperationsByStatus(OperationStatus operationStatus) {
        List<SellOperationEntity> allPendingSellOperation = sellOperationDao.getAllByOperationStatus(operationStatus.value());
        return sellOperationMapper.toSellOperationsModel(allPendingSellOperation);
    }

//    @Override
//    public List<BuyOperation> getPendingBuyOperations() {
//        List<BuyOperationEntity> allPendingBuyOperation = buyOperationDao.getAllByOperationStatus(OperationStatus.PENDING.value());
//        return buyOperationMapper.toBuyOperationsModel(allPendingBuyOperation);
//    }

//    @Override
//    public List<SellOperation> getPendingSellOperations() {
//        List<SellOperationEntity> allPendingSellOperation = sellOperationDao.getAllByOperationStatus(OperationStatus.PENDING.value());
//        return sellOperationMapper.toSellOperationsModel(allPendingSellOperation);
//    }

    @Override
    public List<BuyOperation> getDoneBuyOperations() {
        List<BuyOperationEntity> allPendingBuyOperation = buyOperationDao.getAllByOperationStatus(OperationStatus.DONE.value());
        return buyOperationMapper.toBuyOperationsModel(allPendingBuyOperation);
    }

    @Override
    public List<SellOperation> getSellOperations() {
        List<SellOperationEntity> sellOperationEntities = sellOperationDao.findAll();
        return sellOperationMapper.toSellOperationsModel(sellOperationEntities);
    }
}
