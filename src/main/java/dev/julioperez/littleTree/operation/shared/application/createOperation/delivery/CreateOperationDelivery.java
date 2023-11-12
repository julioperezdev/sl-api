package dev.julioperez.littleTree.operation.shared.application.createOperation.delivery;

import dev.julioperez.littleTree.operation.buyOperation.domain.dto.BuyOperationRequest;
import dev.julioperez.littleTree.operation.sellOperation.domain.dto.SellOperationRequest;
import dev.julioperez.littleTree.operation.shared.domain.port.createOperation.CreateOperation;
import dev.julioperez.littleTree.operation.shared.domain.port.createOperation.CreateOperationInputPort;

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
