package dev.julioperez.littleTree.operation.infrastructure.gateway.pdfBox;

import dev.julioperez.littleTree.operation.domain.model.buyOperation.BuyOperation;
import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;


import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import static org.apache.pdfbox.pdmodel.font.PDType1Font.*;

@Service
@Slf4j
public class GenerateTicketPdfBox {

    public byte[] generateTicketToBuyOperation(BuyOperation buyOperation){
        return generateTicket(
                true,
                buyOperation.getCreatedAt(),
                buyOperation.getClientId(),
                buyOperation.getCurrencyMultiBox(),
                buyOperation.getPrice().toString(),
                buyOperation.getTotal().toString(),
                "Castro Barros 86");
    }
    public byte[] generateTicketToSellOperation(SellOperation sellOperation){
        return generateTicket(
                true,
                sellOperation.getCreatedAt(),
                sellOperation.getClientId(),
                sellOperation.getCurrencyMultiBox(),
                sellOperation.getPrice().toString(),
                sellOperation.getTotal().toString(),
                "Castro Barros 86");
    }
    public byte[] generateTicket(boolean isBuyOperation, Date date, String clientName, String foreignCurrency, String importValue, String price, String address){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try{
            PDDocument document = new PDDocument();
            setMetadataOfTicket(document);
            instancePageSettings(document);
            PDPageContentStream contentStream = instanceContentSettings(document, document.getPage(0));
            instanceContent(contentStream, isBuyOperation, date, clientName, foreignCurrency, importValue, price, address);
            document.save(out);
            document.close();
        }catch (Exception exception){
            log.error(exception.getMessage());
            throw new IllegalArgumentException("Error to generate Ticket "+ Arrays.toString(exception.getStackTrace()));
        }
        return out.toByteArray();
    }

    private void setMetadataOfTicket(PDDocument document){
        PDDocumentInformation pdDocumentInformation = document.getDocumentInformation();
        pdDocumentInformation.setAuthor("Pago Facil");
        pdDocumentInformation.setTitle("Titulo");
        pdDocumentInformation.setSubject("Venta de OPERACION ID");
        pdDocumentInformation.setCreationDate(Calendar.getInstance());
    }
    private void instancePageSettings(PDDocument document) throws IOException {
        //PDRectangle pageSize = new PDRectangle(79.5f, 100);
        PDPage page = new PDPage(PDRectangle.A6);
        document.addPage(page);
    }
    private PDPageContentStream instanceContentSettings(PDDocument document, PDPage page) throws IOException {
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.setFont(HELVETICA, 12);
        contentStream.setLeading(10);
        return contentStream;
    }
    private void instanceContent(PDPageContentStream contentStream,boolean isBuyOperation,Date date, String clientName, String foreignCurrency, String importValue, String price, String address) throws IOException {
        contentStream.beginText();
        //contentStream.newLineAtOffset( 10, page.getMediaBox().getHeight() - 10);
        contentStream.newLineAtOffset( 10, 200);
        contentStream.showText("Fecha: " + date);
        contentStream.newLine();
        contentStream.showText("Apodo Cliente: " + clientName);
        contentStream.newLine();
        String operationType = isBuyOperation ? "Compra" : "Venta";
        contentStream.showText("Tipo Operación: " + operationType);
        contentStream.newLine();
        contentStream.showText("Tipo de Divisa: " + foreignCurrency);
        contentStream.newLine();
        contentStream.showText("Importe: " + importValue);
        contentStream.newLine();
        String operationDescription = isBuyOperation ? "Importe a Cobrar: " : "Importe a Pagar: ";
        contentStream.showText(operationDescription + price + " Pesos");
        if(!isBuyOperation){
            contentStream.newLine();
            contentStream.showText("Dirección: " + address);
        }
        contentStream.endText();
        contentStream.close();
        //return contentStream;
    }
    /*
    public static void main(String[] args) throws IOException {
        String idPDF = Instant.now().toString();//UUID.randomUUID().toString();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try{
            PDDocument document = new PDDocument();
            PDDocumentInformation pdDocumentInformation = document.getDocumentInformation();
            pdDocumentInformation.setAuthor("Pago Facil");
            pdDocumentInformation.setTitle("Titulo");
            pdDocumentInformation.setSubject("Venta de OPERACION ID");
            pdDocumentInformation.setCreationDate(Calendar.getInstance());

            //PDRectangle pageSize = new PDRectangle(79.5f, 100);
            PDPage page = new PDPage(PDRectangle.A6);
            document.addPage(page);
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            //Standard14Fonts.FontName font = Standard14Fonts.FontName.HELVETICA;
            contentStream.setFont(HELVETICA, 12);
            contentStream.setLeading(10);
            contentStream.beginText();
            contentStream.newLineAtOffset( 10, page.getMediaBox().getHeight() - 10);
            contentStream.showText("Fecha: 15-04-2023 09:24:44");
            contentStream.newLine();
            contentStream.showText("Apodo Cliente: Julio Perez");
            contentStream.newLine();
            contentStream.showText("Tipo Operación: Compra");
            contentStream.newLine();
            contentStream.showText("Tipo de Divisa: Dolar Grande");
            contentStream.newLine();
            contentStream.showText("Importe: 550");
            contentStream.newLine();
            //Operacion Venta:"Importe a Cobrar"
            //Operacion Compra:"Importe a Pagar"
            contentStream.showText("Importe a Cobrar: 550000 Pesos");
            contentStream.endText();
            //El ticket para la oficina debe colocarse la direccion
            contentStream.close();



            document.save(out);
            document.close();

        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        System.out.println("se hice el pdf");
        System.out.println(Arrays.toString(out.toByteArray()));
    }

     */
}
