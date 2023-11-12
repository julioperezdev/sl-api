package dev.julioperez.littleTree.operation.sellOperation.domain.port.generateTicket;

import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;

public interface GenerateTicket {
    byte[] generateBuyOperationTicket(BuyOperation buyOperation);
    byte[] generateSellOperationTicket(SellOperation sellOperation);
}
