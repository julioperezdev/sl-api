package dev.julioperez.littleTree.operation.shared.domain.port.pendingOperation;

import dev.julioperez.littleTree.seller.sellerCommission.domain.dto.CreateSellerCommissionRequest;

public interface PendingOperation {
    boolean changePendingToExecuteOperation(String operationId, String operationType, CreateSellerCommissionRequest createSellerCommissionRequest);
}
