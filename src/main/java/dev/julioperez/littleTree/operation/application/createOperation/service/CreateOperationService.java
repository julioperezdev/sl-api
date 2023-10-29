package dev.julioperez.littleTree.operation.application.createOperation.service;

import dev.julioperez.littleTree.box.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.box.domain.port.updateCurrencyMultiBox.UpdateCurrencyMultiBox;
import dev.julioperez.littleTree.operation.domain.dto.*;
import dev.julioperez.littleTree.operation.domain.enums.OperationStatus;
import dev.julioperez.littleTree.operation.domain.enums.OperationType;
import dev.julioperez.littleTree.operation.domain.model.buyOperation.BuyOperation;
import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperation;
import dev.julioperez.littleTree.operation.domain.port.createOperation.CreateOperation;
import dev.julioperez.littleTree.operation.domain.port.createOperation.CreateOperationOutputPort;
import dev.julioperez.littleTree.operation.domain.port.getOperations.GetOperations;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class CreateOperationService implements CreateOperation {
    private final CreateOperationOutputPort createOperationOutputPort;
    private final UpdateCurrencyMultiBox updateCurrencyMultiBox;
    private final GetOperations getOperations;

    public CreateOperationService(CreateOperationOutputPort createOperationOutputPort, UpdateCurrencyMultiBox updateCurrencyMultiBox, GetOperations getOperations) {
        this.createOperationOutputPort = createOperationOutputPort;
        this.updateCurrencyMultiBox = updateCurrencyMultiBox;
        this.getOperations = getOperations;
    }

    @Override
    public boolean createBuyOperationToBePending(BuyOperationRequest buyOperationRequest){
        //get data of client
        //validate if client have DifferenceClient on frontend
        List<String> operationTypes = buyOperationRequest.buyOperationData().stream().map(BuyOperationData::operationType).toList();
        boolean isValidBuyOperation = OperationType.hasOnlyBuyOperations(operationTypes);
        if(!isValidBuyOperation) throw new IllegalArgumentException("every operation should be BUY operation, cant be different");
        List<BuyOperation> buyOperationsSaved = startBuyOperation(buyOperationRequest);
        return updateCurrencyMultiBox.reservePendingCurrencyBoxAfterOfBuyOperation(buyOperationsSaved);
    }
    @Override
    public boolean createSellOperationToBePending(SellOperationRequest sellOperationRequest) {
        List<String> operationTypes = sellOperationRequest.sellOperationData().stream().map(SellOperationData::operationType).toList();
        boolean isValidSellOperation = OperationType.hasOnlySellOperation(operationTypes);
        if(!isValidSellOperation) throw new IllegalArgumentException("every operation should be SELL operation, cant be different");
        List<SellOperation> sellOperationsSaved = startSellOperation(sellOperationRequest);
        //should call foreignBox and PesosBox to manage quantity
        boolean currenciesReserved = updateCurrencyMultiBox.reservePendingCurrencyBoxAfterOfSellOperation(sellOperationsSaved);

        //should call balance on this moment?
        //show do an iteration of each sellOperation saved
        //manageBalance.createBalance(new Balance(UUID.randomUUID().toString(),sellOperationsSaved.get(0).getProfit(),sellOperationsSaved.get(0).getId()));

        //should call seller commission if required
        //should call seller commission on this moment?
//        if(!sellOperationRequest.hasSeller()) return true;
//        SellOperation sellOperation = sellOperationsSaved.get(0);
//        CreateSellerCommissionRequest createSellerCommissionRequest = new CreateSellerCommissionRequest(sellOperationRequest.sellerCommission(), sellOperation.getQuantity(), sellOperationRequest.sellerCommission(), sellOperationRequest.sellerId(), SellerCommissionStatus.PENDING.value());
//        createSellerCommission.createSellerCommission(createSellerCommissionRequest);
        return true;
    }
    //should be received a list with N Operations of same client,but also same seller and commissions?
    private List<BuyOperation> startBuyOperation(BuyOperationRequest buyOperationsRequest){
        //This information should be used it with a ModelMapper
        /**
         *         define foreign currency
         *         show a popup with the prices of foreign currencies on frontend
         *         set buyPrice
         *         set quantity to buy
         *         total in pesos to pay
         *         if Currency is DOLLAR_SMALL should use two fields more
         *         set percent by DOLLAR_SMALL
         *         set result of (total in pesos)X(percent)
         *         -------------------
         *         before to finalize can call the follow methods
         *         to generateOtherOperation, can use client info to do other data operation
         *         to officeCheck, should call officeDebt Box to use money here and not to Pesos Box
         *         to executeOperation, should save operation with pending status to be close in a future by other useCase
         */
        List<BuyOperation> buyOperations = generateBuyOperations(buyOperationsRequest);
        return createOperationOutputPort.saveBuyOperations(buyOperations);
    }
    private List<BuyOperation> generateBuyOperations(BuyOperationRequest buyOperationsRequest){
        return buyOperationsRequest.buyOperationData()
                .stream()
                .map(particular -> this.generateParticularBuyOperation(buyOperationsRequest.id(),buyOperationsRequest.hasOfficeCheck(),buyOperationsRequest.clientId(), particular))
                .toList();
    }
    private BuyOperation generateParticularBuyOperation(String id,boolean hasOfficeCheck, String clientId, BuyOperationData buyOperationData){
        return new BuyOperation(
                id,
                Date.from(Instant.now()),
                Date.from(Instant.now()),
                clientId,
                buyOperationData.currencyMultiBox(),
                buyOperationData.buyPrice(),
                buyOperationData.quantity(),
                buyOperationData.percent(),
                calculateTotalPriceToBuyOperation(buyOperationData),
                hasOfficeCheck,
                OperationStatus.PENDING.value(),
                buyOperationData.quantity());
    }
    private Float calculateTotalPriceToBuyOperation(BuyOperationData buyOperationData){
        float totalPriceInPesos = 0f;
        totalPriceInPesos = buyOperationData.buyPrice() * buyOperationData.quantity();
        if(buyOperationData.currencyMultiBox().equals(CurrencyBox.USD_LOW.value())){
            Float percent = buyOperationData.percent();
            Float newBuyPrice = buyOperationData.buyPrice() - ((buyOperationData.buyPrice() * percent)/100);
            totalPriceInPesos = newBuyPrice * buyOperationData.quantity();
        }
        return totalPriceInPesos;
    }
    private List<SellOperation> startSellOperation(SellOperationRequest sellOperationsRequest){
        /**
         * when OJO select and set buyPrice of table with previous buyOperation
         * each selection correspond to particular operation?
         */
        /**
         *         This information should be used it with a ModelMapper
         *         define foreign currency
         *         show a popup with the prices of foreign currencies on frontend
         *         OJO select and set buyPrice of table with previous buyOperation
         *         set sellPrice
         *         set quantity to sell
         *         total in pesos, multiply sellQuantity and sellPrice
         *         get profit multiply sellQuantity and selection of buyPrice
         *         Optional assign seller(re-read to analyse this useCase)
         *         if seller is selected, call method to add seller commission
         *         and this information should be saved on SellOperation
         *         sellerName, sellerProfit, finalProfit that is result of (profit in pesos)-(sellerProfit)
         *         result of finalProfit should be sent to Balance Box
         *         to executeOperation, should save operation with pending status to be close in a future by other useCase
         */
        List<SellOperation> sellOperations = generateSellOperations(sellOperationsRequest);
        return createOperationOutputPort.saveSellOperations(sellOperations);
    }
    private List<SellOperation> generateSellOperations(SellOperationRequest sellOperationsRequest){
        return sellOperationsRequest.sellOperationData()
                .stream()
                .map(particular -> this.generateParticularSellOperation(sellOperationsRequest.id(),sellOperationsRequest.clientId(), particular))
                .toList();
    }
    private SellOperation generateParticularSellOperation(String id,String clientId,SellOperationData sellOperationData){
        boolean isReducedSuccess = reduceReserveOfBuyOperationById(sellOperationData);
        if(!isReducedSuccess) throw new IllegalArgumentException("cant be completed because need a reduce reserve to create a sell operation");
        return new SellOperation(
                id,
                Date.from(Instant.now()),
                Date.from(Instant.now()),
                clientId,
                sellOperationData.currencyMultiBox(),
                sellOperationData.sellPrice(),
                sellOperationData.quantityToSell(),
                calculateSubProfitToSellOperation(sellOperationData),
                calculateProfitToSellOperation(sellOperationData),
                calculateTotalPriceToSellOperation(sellOperationData),
                sellOperationData.sellerId(),
                OperationStatus.PENDING.value(),
                sellOperationData.sellerCommission());
    }

    private boolean reduceReserveOfBuyOperationById(SellOperationData sellOperationData){
        BuyOperation buyOperation = getOperations.getBuyOperationById(sellOperationData.buyOperationId()).orElseThrow(()-> new IllegalArgumentException(String.format("%s buyOperation ID dont exist", sellOperationData.buyOperationId())));
        if(!sellOperationData.currencyMultiBox().equals(buyOperation.getCurrencyMultiBox())) throw new IllegalArgumentException(String.format("%s foreignExchange found should be same of %s foreign exchange box", buyOperation.getCurrencyMultiBox(), sellOperationData.currencyMultiBox()));
        if(!buyOperation.getOperationStatus().equals(OperationStatus.DONE.value())) throw new IllegalArgumentException(String.format("%s Status of foreignExchange found should be same of DONE", buyOperation.getOperationStatus()));
        if(!sellOperationData.buyPrice().equals(buyOperation.getPrice())) throw new IllegalArgumentException(String.format("%s SellOperationData.buyPrice should be same like %s value because this is the BUY PRICE of foreign exchange box", sellOperationData.buyPrice(), buyOperation.getPrice()));
        Float newReserveAmountForThisOperation = buyOperation.reduceReserve(sellOperationData.quantityToSell());
        buyOperation = new BuyOperation(
                buyOperation.getId(),
                buyOperation.getCreatedAt(),
                Date.from(Instant.now()),
                buyOperation.getClientId(),
                buyOperation.getCurrencyMultiBox(),
                buyOperation.getPrice(),
                buyOperation.getQuantity(),
                buyOperation.getPercent(),
                buyOperation.getTotal(),
                buyOperation.hasOfficeCheck(),
                buyOperation.getOperationStatus(),
                newReserveAmountForThisOperation);
        if(newReserveAmountForThisOperation < 0) throw new IllegalArgumentException("newReserveAmountForThisOperation cant be less of zero");
        List<BuyOperation> buyOperationUpdated = createOperationOutputPort.saveBuyOperations(List.of(buyOperation));
        return buyOperationUpdated.size() == 1
                && buyOperationUpdated.get(0).getReserve()
                .equals(newReserveAmountForThisOperation);
    }
    private Float calculateTotalPriceToSellOperation(SellOperationData sellOperationData){
        return sellOperationData.sellPrice() * sellOperationData.quantityToSell();
    }
    private Float calculateSubProfitToSellOperation(SellOperationData sellOperationData){
        float totalPriceInPesos = calculateTotalPriceToSellOperation(sellOperationData);
        float subProfit =  totalPriceInPesos - (sellOperationData.buyPrice() * sellOperationData.quantityToSell());
        if(subProfit < 0) throw new IllegalArgumentException("Cant have negative result or is correct?");
        return subProfit;
    }
    private Float calculateProfitToSellOperation(SellOperationData sellOperationData){
        //re check if necessary define one sellerCommission for all transactions or different commissions by operations
        //validate if correct analogy on profit and sub_profit
        float subProfit = calculateSubProfitToSellOperation(sellOperationData);
        if(!sellOperationData.hasSeller()) return subProfit;
        //float profit = sellerCommission * sellOperationData.quantityToSell();
        //float profit = subProfit - (sellOperationData.sellerCommission() * sellOperationData.quantityToSell());
        //recordar que el profit puede ser negativo, hay que hacer pruebas para estos casos
        return  subProfit - sellOperationData.sellerCommission();
        //if(profit < 0) throw new IllegalArgumentException("Cant have negative result or is correct? or some error");
        //return profit;
    }
}
