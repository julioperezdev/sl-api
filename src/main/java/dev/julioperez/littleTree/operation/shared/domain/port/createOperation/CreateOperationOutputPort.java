package dev.julioperez.littleTree.operation.shared.domain.port.createOperation;

import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;

import java.util.List;

public interface CreateOperationOutputPort {

    List<BuyOperation> saveBuyOperations(List<BuyOperation> buyOperations);
    List<SellOperation> saveSellOperations(List<SellOperation> sellOperations);
}
