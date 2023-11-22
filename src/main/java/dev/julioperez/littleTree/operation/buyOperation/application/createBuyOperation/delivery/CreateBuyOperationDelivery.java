package dev.julioperez.littleTree.operation.buyOperation.application.createBuyOperation.delivery;

import dev.julioperez.littleTree.operation.buyOperation.domain.dto.BuyOperationRequest;
import dev.julioperez.littleTree.operation.buyOperation.domain.port.createBuyOperation.CreateBuyOperation;
import dev.julioperez.littleTree.operation.buyOperation.domain.port.createBuyOperation.CreateBuyOperationInputPort;

public class CreateBuyOperationDelivery implements CreateBuyOperationInputPort {
    private final CreateBuyOperation createBuyOperation;

    public CreateBuyOperationDelivery(CreateBuyOperation createBuyOperation) {
        this.createBuyOperation = createBuyOperation;
    }

    @Override
    public boolean createBuyOperation(BuyOperationRequest buyOperationRequest) {
        return createBuyOperation.execute(buyOperationRequest);
    }
}
