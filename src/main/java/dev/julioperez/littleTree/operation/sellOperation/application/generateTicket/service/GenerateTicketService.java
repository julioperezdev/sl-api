package dev.julioperez.littleTree.operation.sellOperation.application.generateTicket.service;

import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.port.generateTicket.GenerateTicket;
import dev.julioperez.littleTree.operation.sellOperation.domain.port.generateTicket.GenerateTicketOutputPortGateway;

public class GenerateTicketService implements GenerateTicket {

    private final GenerateTicketOutputPortGateway generateTicketOutputPortGateway;

    public GenerateTicketService(GenerateTicketOutputPortGateway generateTicketOutputPortGateway) {
        this.generateTicketOutputPortGateway = generateTicketOutputPortGateway;
    }

    public byte[] generateBuyOperationTicket(BuyOperation buyOperation){
        return generateTicketOutputPortGateway.generateBuyOperationTicket(buyOperation);
    }

    public byte[] generateSellOperationTicket(SellOperation sellOperation){
        return generateTicketOutputPortGateway.generateSellOperationTicket(sellOperation);
    }
}
