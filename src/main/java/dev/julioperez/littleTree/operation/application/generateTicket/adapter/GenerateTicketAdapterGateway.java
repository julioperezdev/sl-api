package dev.julioperez.littleTree.operation.application.generateTicket.adapter;

import dev.julioperez.littleTree.operation.domain.model.buyOperation.BuyOperation;
import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperation;
import dev.julioperez.littleTree.operation.domain.port.generateTicket.GenerateTicketOutputPortGateway;
import dev.julioperez.littleTree.operation.infrastructure.gateway.pdfBox.GenerateTicketPdfBox;

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
