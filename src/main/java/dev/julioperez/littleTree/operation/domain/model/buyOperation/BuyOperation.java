package dev.julioperez.littleTree.operation.domain.model.buyOperation;


import dev.julioperez.littleTree.box.domain.enums.CurrencyBox;
import dev.julioperez.littleTree.box.domain.model.CurrencyMultiBox;
import dev.julioperez.littleTree.box.domain.model.CurrencyMultiBoxId;
import dev.julioperez.littleTree.client.domain.model.ClientId;
import dev.julioperez.littleTree.operation.domain.enums.OperationStatus;
import dev.julioperez.littleTree.operation.domain.model.operation.OperationId;
import dev.julioperez.littleTree.seller.domain.model.SellerId;

import java.util.Date;

public final class BuyOperation {

    private final BuyOperationId id;
    private final BuyOperationCreatedAt createdAt;
    private final ClientId clientId;
    private final CurrencyBox currencyMultiBox;
    private final BuyOperationPrice price;
    private final BuyOperationQuantity quantity;
    private final BuyOperationPercent percent;
    private final BuyOperationTotal total;
    private final BuyOperationOfficeCheck officeCheck;
    private OperationStatus operationStatus;
    private final BuyOperationReserve reserve;

    public BuyOperation(String id, Date createdAt, String clientId, String currencyMultiBox, Float price, Float quantity, Float percent, Float total, boolean officeCheck, String operationStatus, Float reserve) {
        this.id = new BuyOperationId(id);
        this.createdAt = new BuyOperationCreatedAt(createdAt);
        this.clientId = new ClientId(clientId);
        this.currencyMultiBox = CurrencyBox.returnCurrencyBoxByDescription(currencyMultiBox);
        this.price = new BuyOperationPrice(price);
        this.quantity = new BuyOperationQuantity(quantity);
        this.percent = ensureSetPercentValueOnUsdLowForeignCurrency(percent, this.currencyMultiBox);
        this.total = new BuyOperationTotal(total);
        this.officeCheck = new BuyOperationOfficeCheck(officeCheck);
        this.operationStatus = OperationStatus.returnOperationStatusByDescription(operationStatus);
        this.reserve = new BuyOperationReserve(reserve);
    }


    public String getId() {
        return id.value();
    }

    public Date getCreatedAt() {
        return createdAt.value();
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

    public Float getPercent() {
        return percent.value();
    }

    public Float getTotal() {
        return total.value();
    }

    public boolean hasOfficeCheck() {
        return officeCheck.value();
    }
    public String getOperationStatus() {
        return operationStatus.value();
    }
    public void updateOperationStatus(OperationStatus operationStatus){
        this.operationStatus = operationStatus;
    }

    public Float getReserve() {
        return reserve.value();
    }
    public Float addReserve(Float amount){
        return this.getReserve() + amount;
    }

    public Float reduceReserve(Float amount){
        return this.getReserve() - amount;
    }

    private BuyOperationPercent ensureSetPercentValueOnUsdLowForeignCurrency(Float value, CurrencyBox currencyMultiBox){
        Float percent = currencyMultiBox.equals(CurrencyBox.USD_LOW) ? value : 0;
        return new BuyOperationPercent(percent);
    }
}
