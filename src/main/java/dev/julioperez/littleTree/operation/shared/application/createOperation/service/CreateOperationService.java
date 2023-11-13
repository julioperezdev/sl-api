package dev.julioperez.littleTree.operation.shared.application.createOperation.service;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.getCurrencyMultibox.GetCurrencyMultibox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.updateCurrencyMultiBox.UpdateCurrencyMultiBox;
import dev.julioperez.littleTree.operation.buyOperation.domain.dto.BuyOperationData;
import dev.julioperez.littleTree.operation.buyOperation.domain.dto.BuyOperationRequest;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationStatus;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationType;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperation;
import dev.julioperez.littleTree.operation.shared.domain.port.createOperation.CreateOperation;
import dev.julioperez.littleTree.operation.shared.domain.port.createOperation.CreateOperationOutputPort;
import dev.julioperez.littleTree.operation.shared.domain.port.getOperations.GetOperations;
import dev.julioperez.littleTree.operation.sellOperation.domain.dto.SellOperationData;
import dev.julioperez.littleTree.operation.sellOperation.domain.dto.SellOperationRequest;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class CreateOperationService implements CreateOperation {
    private final CreateOperationOutputPort createOperationOutputPort;
    private final GetCurrencyMultibox getCurrencyMultibox;
    private final UpdateCurrencyMultiBox updateCurrencyMultiBox;
    private final GetOperations getOperations;

    public CreateOperationService(CreateOperationOutputPort createOperationOutputPort, GetCurrencyMultibox getCurrencyMultibox, UpdateCurrencyMultiBox updateCurrencyMultiBox, GetOperations getOperations) {
        this.createOperationOutputPort = createOperationOutputPort;
        this.getCurrencyMultibox = getCurrencyMultibox;
        this.updateCurrencyMultiBox = updateCurrencyMultiBox;
        this.getOperations = getOperations;
    }

    @Override
    public boolean createBuyOperationToBePending(BuyOperationRequest buyOperationRequest){
        List<String> operationTypes = buyOperationRequest.buyOperationData().stream().map(BuyOperationData::operationType).toList();
        boolean isValidBuyOperation = OperationType.hasOnlyBuyOperations(operationTypes);
        if(!isValidBuyOperation) throw new IllegalArgumentException("every operation should be BUY operation, cant be different");
        //validate if all buy operation can be completed with total quantity of pesos
        Float pesosBoxTotal = getCurrencyMultibox.getTotalByCurrencyBox(CurrencyBox.PESO);
        double allBuyOperationSum = buyOperationRequest.buyOperationData().stream().filter(particular -> !particular.hasOfficeCheck()).mapToDouble(this::calculateTotalPriceToBuyOperation).sum();
        if(pesosBoxTotal < allBuyOperationSum) throw new IllegalArgumentException(String.format("Dont do the operations because all new operations is more of pesos, pesos: %f, operations: %f", pesosBoxTotal, allBuyOperationSum));
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
                //.map(particular -> this.generateParticularBuyOperation(buyOperationsRequest.id(),buyOperationsRequest.hasOfficeCheck(),buyOperationsRequest.clientId(), particular))
                .map(this::generateParticularBuyOperation)
                .toList();
    }
    private BuyOperation generateParticularBuyOperation(BuyOperationData buyOperationData){
        return new BuyOperation(
                buyOperationData.id(),
                Date.from(Instant.now()),
                Date.from(Instant.now()),
                buyOperationData.clientId(),
                buyOperationData.currencyMultiBox(),
                buyOperationData.buyPrice(),
                buyOperationData.quantity(),
                buyOperationData.percent(),
                calculateTotalPriceToBuyOperation(buyOperationData),
                buyOperationData.hasOfficeCheck(),
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
