package dev.julioperez.littleTree.operation.domain.port.executeSellOperation;

import dev.julioperez.littleTree.operation.domain.model.operation.Operation;
import dev.julioperez.littleTree.seller.domain.dto.CreateSellerCommissionRequest;

public interface ExecuteSellOperation {
    boolean executeSellOperation(String operationId, CreateSellerCommissionRequest createSellerCommissionRequest);
}
