package dev.julioperez.littleTree.seller.sellerCommission.domain.model;

import dev.julioperez.littleTree.operation.sellOperation.domain.model.SellOperationId;
import dev.julioperez.littleTree.seller.seller.domain.model.SellerId;
import dev.julioperez.littleTree.seller.sellerCommission.domain.enums.SellerCommissionStatus;

import java.util.Date;

public final class SellerCommission {
    private final SellerCommissionId id;
    private final SellOperationId operationId;
    private final SellerCommissionTotal total;
    private final SellerCommissionProfit profit;
    private final SellerCommissionQuantity quantity;
    private final SellerCommissionPesos pesos;
    private final SellerId sellerId;
    private final SellerCommissionStatus sellerCommissionStatus;
    private final SellerCommissionCreatedAt createdAt;
    private final SellerCommissionUpdatedAt updatedAt;

    public SellerCommission(String id, String operationId, Float total, Float profit, Float quantity, Float pesos, String sellerId, String sellerCommissionStatus, Date createdAt, Date updatedAt) {
        this.id = new SellerCommissionId(id);
        this.operationId = new SellOperationId(operationId);
        this.total = new SellerCommissionTotal(total);
        this.profit = new SellerCommissionProfit(profit);
        this.quantity = new SellerCommissionQuantity(quantity);
        this.pesos = new SellerCommissionPesos(pesos);
        this.sellerId = new SellerId(sellerId);
        this.sellerCommissionStatus = SellerCommissionStatus.returnSellerCommissionStatusByDescription(sellerCommissionStatus);
        this.createdAt = new SellerCommissionCreatedAt(createdAt);
        this.updatedAt = new SellerCommissionUpdatedAt(updatedAt);
    }

    public String getId() {
        return id.value();
    }

    public String getOperationId() {
        return operationId.value();
    }

    public Float getTotal() {
        return total.value();
    }

    public Float getProfit() {
        return profit.value();
    }

    public Float getQuantity(){
        return quantity.value();
    }

    public Float getPesos(){
        return pesos.value();
    }
    public String getSellerId() {
        return sellerId.value();
    }

    public String getStatus() {
        return sellerCommissionStatus.value();
    }
    public Date getCreatedAt(){
        return createdAt.value();
    }
    public Date getUpdatedAt(){
        return updatedAt.value();
    }

}
