package dev.julioperez.littleTree.operation.application.createOperation.delivery;

import dev.julioperez.littleTree.operation.domain.dto.BuyOperationRequest;
import dev.julioperez.littleTree.operation.domain.dto.SellOperationRequest;
import dev.julioperez.littleTree.operation.domain.model.operation.Operation;
import dev.julioperez.littleTree.operation.domain.port.createOperation.CreateOperation;
import dev.julioperez.littleTree.operation.domain.port.createOperation.CreateOperationInputPort;

public class CreateOperationDelivery implements CreateOperationInputPort {
    private final CreateOperation createOperation;

    public CreateOperationDelivery(CreateOperation createOperation) {
        this.createOperation = createOperation;
    }

    @Override
    public boolean createBuyOperation(BuyOperationRequest buyOperationRequest) {
        return createOperation.createBuyOperationToBePending(buyOperationRequest);
    }

    @Override
    public boolean createSellOperation(SellOperationRequest sellOperationRequest) {
        return createOperation.createSellOperationToBePending(sellOperationRequest);
    }
}
