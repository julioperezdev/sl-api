package dev.julioperez.littleTree.operation.sellOperation.application.createSellOperation.delivery;

import dev.julioperez.littleTree.operation.sellOperation.domain.dto.SellOperationRequest;
import dev.julioperez.littleTree.operation.sellOperation.domain.port.createSellOperation.CreateSellOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.port.createSellOperation.CreateSellOperationInputPort;

public class CreateSellOperationDelivery implements CreateSellOperationInputPort {
    private final CreateSellOperation createSellOperation;

    public CreateSellOperationDelivery(CreateSellOperation createSellOperation) {
        this.createSellOperation = createSellOperation;
    }

    @Override
    public boolean createSellOperation(SellOperationRequest sellOperationRequest) {
        return createSellOperation.execute(sellOperationRequest);
    }
}
