package dev.julioperez.littleTree.operation.sellOperation.application.createSellOperation.service;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.reservePendingCurrencyBoxAfterOfSellOperation.ReservePendingCurrencyBoxAfterOfSellOperation;
import dev.julioperez.littleTree.operation.buyOperation.application.updateBuyOperation.service.UpdateBuyOperationService;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.dto.SellOperationData;
import dev.julioperez.littleTree.operation.sellOperation.domain.dto.SellOperationRequest;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.port.createSellOperation.CreateSellOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.port.createSellOperation.CreateSellOperationOutputPort;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationStatus;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationType;
import dev.julioperez.littleTree.operation.shared.domain.port.getOperations.GetOperations;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class CreateSellOperationService implements CreateSellOperation {
    private final CreateSellOperationOutputPort createSellOperationOutputPort;
    private final GetOperations getOperations;
    private final UpdateBuyOperationService updateBuyOperationService;
    private final ReservePendingCurrencyBoxAfterOfSellOperation reservePendingCurrencyBoxAfterOfSellOperation;

    public CreateSellOperationService(CreateSellOperationOutputPort createSellOperationOutputPort, GetOperations getOperations, UpdateBuyOperationService updateBuyOperationService, ReservePendingCurrencyBoxAfterOfSellOperation reservePendingCurrencyBoxAfterOfSellOperation) {
        this.createSellOperationOutputPort = createSellOperationOutputPort;
        this.getOperations = getOperations;
        this.updateBuyOperationService = updateBuyOperationService;
        this.reservePendingCurrencyBoxAfterOfSellOperation = reservePendingCurrencyBoxAfterOfSellOperation;
    }

    @Override
    public boolean execute(SellOperationRequest sellOperationRequest) {
        List<String> operationTypes = sellOperationRequest.sellOperationData().stream().map(SellOperationData::operationType).toList();
        boolean isValidSellOperation = OperationType.hasOnlySellOperation(operationTypes);
        if(!isValidSellOperation) throw new IllegalArgumentException("every operation should be SELL operation, cant be different");
        List<SellOperation> sellOperationsSaved = startSellOperation(sellOperationRequest);
        boolean currenciesReserved = reservePendingCurrencyBoxAfterOfSellOperation.execute(sellOperationsSaved);
        return true;
    }

    private List<SellOperation> startSellOperation(SellOperationRequest sellOperationsRequest){
        List<SellOperation> sellOperations = generateSellOperations(sellOperationsRequest);
        return createSellOperationOutputPort.saveSellOperations(sellOperations);
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
        List<BuyOperation> buyOperationUpdated = updateBuyOperationService.execute(List.of(buyOperation));
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
        //if(subProfit < 0) throw new IllegalArgumentException("Cant have negative result or is correct?");
        return subProfit;
    }
    private Float calculateProfitToSellOperation(SellOperationData sellOperationData){
        float subProfit = calculateSubProfitToSellOperation(sellOperationData);
        if(!sellOperationData.hasSeller()) return subProfit;
        return  subProfit - sellOperationData.sellerCommission();
    }
}
