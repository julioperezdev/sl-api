package dev.julioperez.littleTree.operation.application.generateTicket.service;

import dev.julioperez.littleTree.operation.domain.model.buyOperation.BuyOperation;
import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperation;
import dev.julioperez.littleTree.operation.domain.port.generateTicket.GenerateTicket;
import dev.julioperez.littleTree.operation.domain.port.generateTicket.GenerateTicketOutputPortGateway;

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
