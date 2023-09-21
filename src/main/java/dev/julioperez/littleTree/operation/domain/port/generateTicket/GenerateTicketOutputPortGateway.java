package dev.julioperez.littleTree.operation.domain.port.generateTicket;

import dev.julioperez.littleTree.operation.domain.model.buyOperation.BuyOperation;
import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperation;

public interface GenerateTicketOutputPortGateway {

    byte[] generateBuyOperationTicket(BuyOperation buyOperation);
    byte[] generateSellOperationTicket(SellOperation sellOperation);
}
