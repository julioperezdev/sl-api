package dev.julioperez.littleTree.operation.domain.port.pendingOperation;

import dev.julioperez.littleTree.seller.domain.dto.CreateSellerCommissionRequest;

public interface PendingOperation {
    boolean changePendingToExecuteOperation(String operationId, String operationType, CreateSellerCommissionRequest createSellerCommissionRequest);
}
