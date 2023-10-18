package dev.julioperez.littleTree.operation.domain.model.sellOperation;


import dev.julioperez.littleTree.box.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.client.domain.model.ClientId;
import dev.julioperez.littleTree.operation.domain.enums.OperationStatus;
import dev.julioperez.littleTree.seller.domain.model.SellerId;
import dev.julioperez.littleTree.shared.domain.model.Identifier;

import java.util.Date;
import java.util.Optional;

public final class SellOperation {

    private final SellOperationId id;
    private final SellOperationCreatedAt createdAt;
    private final SellOperationUpdatedAt updatedAt;
    private final ClientId clientId;
    private final CurrencyBox currencyMultiBox;
    private final SellOperationPrice price;
    private final SellOperationQuantity quantity;
    private final SellOperationSubProfit subProfit;
    private final SellOperationProfit profit;
    private final SellOperationTotal total;
    private final Optional<SellerId> sellerId;
    private OperationStatus operationStatus;

    public SellOperation(String id, Date createdAt, Date updatedAt, String clientId, String currencyMultiBox, Float price, Float quantity, Float subProfit, Float profit, Float total, String sellerId, String operationStatus) {
        this.id = new SellOperationId(id);
        this.createdAt = new SellOperationCreatedAt(createdAt);
        this.updatedAt = new SellOperationUpdatedAt(updatedAt);
        this.clientId = new ClientId(clientId);
        this.currencyMultiBox = CurrencyBox.returnCurrencyBoxByDescription(currencyMultiBox);
        this.price = new SellOperationPrice(price);
        this.quantity = new SellOperationQuantity(quantity);
        this.subProfit = new SellOperationSubProfit(subProfit);
        this.profit = new SellOperationProfit(profit);
        this.total = new SellOperationTotal(total);
        this.sellerId = sellerId != null ? Optional.of(new SellerId(sellerId)): Optional.empty();
        this.operationStatus = OperationStatus.returnOperationStatusByDescription(operationStatus);
    }

    public String getId() {
        return id.value();
    }

    public Date getCreatedAt() {
        return createdAt.value();
    }

    public Date getUpdatedAt() {
        return updatedAt.value();
    }

    public String getClientId() {
        return clientId.value();
    }


    public String getCurrencyMultiBox() {
        return currencyMultiBox.value();
    }

    public Float getPrice() {
        return price.value();
    }

    public Float getQuantity() {
        return quantity.value();
    }

    public Float getSubProfit() {
        return subProfit.value();
    }

    public Float getProfit() {
        return profit.value();
    }

    public Float getTotal() {
        return total.value();
    }

    public String getSellerId() {
        return sellerId.map(Identifier::value).orElse(null);
    }

    public String getOperationStatus() {
        return operationStatus.value();
    }

    public void updateOperationStatus(OperationStatus operationStatus){
        this.operationStatus = operationStatus;
    }
    public boolean hasSeller(){
        return this.sellerId.isPresent();
    }
}
