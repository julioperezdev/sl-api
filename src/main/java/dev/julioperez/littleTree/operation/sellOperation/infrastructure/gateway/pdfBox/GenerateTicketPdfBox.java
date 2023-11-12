package dev.julioperez.littleTree.operation.sellOperation.infrastructure.gateway.pdfBox;

import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;
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

    public static void main(String[] args) {
        String idPDF = Instant.now().toString();//UUID.randomUUID().toString();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try{
            PDDocument document = new PDDocument();
            PDDocumentInformation pdDocumentInformation = document.getDocumentInformation();
            pdDocumentInformation.setAuthor("Pago Facil");
            pdDocumentInformation.setTitle("Titulo");
            pdDocumentInformation.setSubject("Venta de OPERACION ID");
            pdDocumentInformation.setCreationDate(Calendar.getInstance());

            PDRectangle pageSize = new PDRectangle(3.14961f, 1.9685f);
            PDPage pageToClient = new PDPage(pageSize);
            PDPage pageToSeller = new PDPage(pageSize);
            document.addPage(pageToClient);
            document.addPage(pageToSeller);
            PDPageContentStream contentStream = new PDPageContentStream(document, pageToClient);
            PDPageContentStream contentStream2 = new PDPageContentStream(document, pageToSeller);
            contentStream.setFont(COURIER_BOLD, 12f);
            contentStream.setLeading(10);
            contentStream.beginText();
            contentStream.newLineAtOffset( 3.8f, pageToClient.getMediaBox().getHeight() - 10f);
            contentStream.showText("*COMPROBANTE PARA CLIENTE*");
            contentStream.setFont(COURIER, 12f);
            contentStream.newLineAtOffset( 0, -10f);
            contentStream.showText("Fecha: 15/04/2023 09:24:44");
            contentStream.newLineAtOffset( 0, -10f);
            contentStream.showText("Cliente: Marcelo Pedromo");
            contentStream.newLineAtOffset( 0, -10f);
            contentStream.showText("Tipo Operación: Compra");
            contentStream.newLineAtOffset( 0, -10f);
            contentStream.showText("Tipo de Divisa: Dolar Grande");
            contentStream.newLineAtOffset( 0, -10f);
            contentStream.showText("Importe: $550");
            contentStream.newLineAtOffset( 0, -10f);
            //Operacion Venta:"Importe a Cobrar"
            //Operacion Compra:"Importe a Pagar"
            contentStream.showText("Importe a Cobrar: $550.000");
            contentStream.endText();
            //El ticket para la oficina debe colocarse la direccion
            contentStream.close();

            //======================================

            contentStream2.setFont(COURIER_BOLD, 12f);
            contentStream2.setLeading(10);
            contentStream2.beginText();
            contentStream2.newLineAtOffset( 3.8f, pageToClient.getMediaBox().getHeight() - 10f);
            contentStream2.showText("*COMPROBANTE PARA OFICINA*");
            contentStream2.setFont(COURIER, 12f);
            contentStream2.newLineAtOffset( 0, -10f);
            contentStream2.showText("Fecha: 15/04/2023 09:24:44");
            contentStream2.newLineAtOffset( 0, -10f);
            contentStream2.showText("Cliente: Marcelo Pedromo");
            contentStream2.newLineAtOffset( 0, -10f);
            contentStream2.showText("Dirección: Carlos Calvo 40");
            contentStream2.newLineAtOffset( 0, -10f);
            contentStream2.showText("Tipo Operación: Compra");
            contentStream2.newLineAtOffset( 0, -10f);
            contentStream2.showText("Tipo de Divisa: Dolar Grande");
            contentStream2.newLineAtOffset( 0, -10f);
            contentStream2.showText("Importe: $550");
            contentStream2.newLineAtOffset( 0, -10f);
            //Operacion Venta:"Importe a Cobrar"
            //Operacion Compra:"Importe a Pagar"
            contentStream2.showText("Importe a Cobrar: $550.000");
            contentStream2.endText();
            //El ticket para la oficina debe colocarse la direccion
            contentStream2.close();



            document.save("z_"+idPDF+".pdf");
            document.close();

        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        System.out.println("se hace el pdf");
        System.out.println(Arrays.toString(out.toByteArray()));
    }


}
