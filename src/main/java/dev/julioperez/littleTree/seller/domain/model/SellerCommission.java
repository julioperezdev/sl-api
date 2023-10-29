package dev.julioperez.littleTree.seller.domain.model;

import dev.julioperez.littleTree.operation.domain.model.sellOperation.SellOperationId;
import dev.julioperez.littleTree.seller.domain.enums.SellerCommissionStatus;

import java.util.Date;

public final class SellerCommission {
    private final SellerCommissionId id;
    private final SellOperationId operationId;
    private final SellerCommissionTotal total;
    private final SellerCommissionProfit profit;
    private final SellerId sellerId;
    private final SellerCommissionStatus sellerCommissionStatus;
    private final SellerCommissionCreatedAt createdAt;
    private final SellerCommissionUpdatedAt updatedAt;

    public SellerCommission(String id, String operationId, Float total, Float profit, String sellerId, String sellerCommissionStatus, Date createdAt, Date updatedAt) {
        this.id = new SellerCommissionId(id);
        this.operationId = new SellOperationId(operationId);
        this.total = new SellerCommissionTotal(total);
        this.profit = new SellerCommissionProfit(profit);
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
