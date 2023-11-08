package dev.julioperez.littleTree.operation.application.createOperation.service;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.updateCurrencyMultiBox.UpdateCurrencyMultiBox;
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
        boolean currenciesReserved = updateCurrencyMultiBox.reservePendingCurrencyBoxAfterOfSellOperation(sellOperationsSaved);
        return true;
    }
    private List<BuyOperation> startBuyOperation(BuyOperationRequest buyOperationsRequest){
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
        float subProfit = calculateSubProfitToSellOperation(sellOperationData);
        if(!sellOperationData.hasSeller()) return subProfit;
        return  subProfit - sellOperationData.sellerCommission();
    }
}
