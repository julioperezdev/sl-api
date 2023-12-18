package dev.julioperez.littleTree.operation.buyOperation.application.createBuyOperation.service;

import dev.julioperez.littleTree.box.currencyBox.shared.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.getCurrencyMultibox.GetCurrencyMultibox;
import dev.julioperez.littleTree.box.currencyBox.shared.domain.port.reservePendingCurrencyBoxAfterOfBuyOperation.ReservePendingCurrencyBoxAfterOfBuyOperation;
import dev.julioperez.littleTree.operation.buyOperation.domain.dto.BuyOperationData;
import dev.julioperez.littleTree.operation.buyOperation.domain.dto.BuyOperationRequest;
import dev.julioperez.littleTree.operation.buyOperation.domain.model.BuyOperation;
import dev.julioperez.littleTree.operation.buyOperation.domain.port.createBuyOperation.CreateBuyOperation;
import dev.julioperez.littleTree.operation.buyOperation.domain.port.createBuyOperation.CreateBuyOperationOutputPort;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationStatus;
import dev.julioperez.littleTree.operation.shared.domain.enums.OperationType;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class CreateBuyOperationService implements CreateBuyOperation {

    private final CreateBuyOperationOutputPort createBuyOperationOutputPort;
    private final GetCurrencyMultibox getCurrencyMultibox;
    private final ReservePendingCurrencyBoxAfterOfBuyOperation reservePendingCurrencyBoxAfterOfBuyOperation;

    public CreateBuyOperationService(CreateBuyOperationOutputPort createBuyOperationOutputPort, GetCurrencyMultibox getCurrencyMultibox, ReservePendingCurrencyBoxAfterOfBuyOperation reservePendingCurrencyBoxAfterOfBuyOperation) {
        this.createBuyOperationOutputPort = createBuyOperationOutputPort;
        this.getCurrencyMultibox = getCurrencyMultibox;
        this.reservePendingCurrencyBoxAfterOfBuyOperation = reservePendingCurrencyBoxAfterOfBuyOperation;
    }

    @Override
    public boolean execute(BuyOperationRequest buyOperationRequest) {
        List<String> operationTypes = buyOperationRequest.buyOperationData().stream().map(BuyOperationData::operationType).toList();
        boolean isValidBuyOperation = OperationType.hasOnlyBuyOperations(operationTypes);
        if(!isValidBuyOperation) throw new IllegalArgumentException("every operation should be BUY operation, cant be different");
        Float pesosBoxTotal = getCurrencyMultibox.getTotalByCurrencyBox(CurrencyBox.PESO);
        double allBuyOperationSum = buyOperationRequest.buyOperationData().stream().filter(particular -> !particular.hasOfficeCheck()).mapToDouble(this::calculateTotalPriceToBuyOperation).sum();
        if(pesosBoxTotal < allBuyOperationSum) throw new IllegalArgumentException(String.format("Dont do the operations because all new operations is more of pesos, pesos: %f, operations: %f", pesosBoxTotal, allBuyOperationSum));
        List<BuyOperation> buyOperationsSaved = startBuyOperation(buyOperationRequest);
        return reservePendingCurrencyBoxAfterOfBuyOperation.execute(buyOperationsSaved);
    }

    private List<BuyOperation> startBuyOperation(BuyOperationRequest buyOperationsRequest){
        List<BuyOperation> buyOperations = generateBuyOperations(buyOperationsRequest);
        return createBuyOperationOutputPort.saveBuyOperations(buyOperations);
    }
    private List<BuyOperation> generateBuyOperations(BuyOperationRequest buyOperationsRequest){
        return buyOperationsRequest.buyOperationData()
                .stream()
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
        if(buyOperationData.currencyMultiBox().equals(CurrencyBox.USD_LOW.value()) && Objects.nonNull(buyOperationData.percent())){
            Float percent = buyOperationData.percent();
            Float newBuyPrice = buyOperationData.buyPrice() - ((buyOperationData.buyPrice() * percent)/100);
            totalPriceInPesos = newBuyPrice * buyOperationData.quantity();
        }
        return totalPriceInPesos;
    }
}
