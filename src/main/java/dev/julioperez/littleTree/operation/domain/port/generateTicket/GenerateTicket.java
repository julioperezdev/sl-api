package dev.julioperez.littleTree.operation.domain.port.generateTicket;

import dev.julioperez.littleTree.operation.domain.model.buyOperation.BuyOperation;
import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperation;

public interface GenerateTicket {
    byte[] generateBuyOperationTicket(BuyOperation buyOperation);
    byte[] generateSellOperationTicket(SellOperation sellOperation);
}
