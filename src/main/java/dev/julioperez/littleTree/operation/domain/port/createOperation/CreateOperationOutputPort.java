package dev.julioperez.littleTree.operation.domain.port.createOperation;

import dev.julioperez.littleTree.operation.domain.model.buyOperation.BuyOperation;
import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperation;

import java.util.List;

public interface CreateOperationOutputPort {

    List<BuyOperation> saveBuyOperations(List<BuyOperation> buyOperations);
    List<SellOperation> saveSellOperations(List<SellOperation> sellOperations);
}
