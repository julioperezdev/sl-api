package dev.julioperez.littleTree.operation.sellOperation.application.generateTicket.adapter;

import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.port.generateTicket.GenerateTicketOutputPortGateway;
import dev.julioperez.littleTree.operation.sellOperation.infrastructure.gateway.pdfBox.GenerateTicketPdfBox;

public class GenerateTicketAdapterGateway implements GenerateTicketOutputPortGateway {
    private final GenerateTicketPdfBox generateTicketPdfBox;

    public GenerateTicketAdapterGateway(GenerateTicketPdfBox generateTicketPdfBox) {
        this.generateTicketPdfBox = generateTicketPdfBox;
    }

    public byte[] generateBuyOperationTicket(BuyOperation buyOperation){
        return generateTicketPdfBox.generateTicketToBuyOperation(buyOperation);
    }

    public byte[] generateSellOperationTicket(SellOperation sellOperation){
        return generateTicketPdfBox.generateTicketToSellOperation(sellOperation);
    }
}
