package dev.julioperez.littleTree.operation.domain.port.executeSellOperation;

import dev.julioperez.littleTree.seller.sellerCommission.domain.dto.CreateSellerCommissionRequest;

public interface ExecuteSellOperation {
    boolean executeSellOperation(String operationId, CreateSellerCommissionRequest createSellerCommissionRequest);
}
