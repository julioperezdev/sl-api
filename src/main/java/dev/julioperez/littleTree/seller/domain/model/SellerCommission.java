package dev.julioperez.littleTree.seller.domain.model;

import dev.julioperez.littleTree.seller.domain.enums.SellerCommissionStatus;

import java.util.Date;

public final class SellerCommission {
    private final SellerCommissionId id;
    private final SellerCommissionPesos pesos;
    private final SellerCommissionQuantity quantity;
    private final SellerCommissionProfit profit;
    private final SellerId sellerId;
    private final SellerCommissionStatus sellerCommissionStatus;
    private final SellerCommissionCreatedAt createdAt;
    private final SellerCommissionUpdatedAt updatedAt;

    public SellerCommission(String id, Float pesos, Float quantity, Float profit, String sellerId, String sellerCommissionStatus, Date createdAt, Date updatedAt) {
        this.id = new SellerCommissionId(id);
        this.pesos = new SellerCommissionPesos(pesos);
        this.quantity = new SellerCommissionQuantity(quantity);
        this.profit = new SellerCommissionProfit(profit);
        this.sellerId = new SellerId(sellerId);
        this.sellerCommissionStatus = SellerCommissionStatus.returnSellerCommissionStatusByDescription(sellerCommissionStatus);
        this.createdAt = new SellerCommissionCreatedAt(createdAt);
        this.updatedAt = new SellerCommissionUpdatedAt(updatedAt);
    }

    public String getId() {
        return id.value();
    }

    public Float getPesos() {
        return pesos.value();
    }

    public Float getQuantity() {
        return quantity.value();
    }

    public Float getProfit() {
        return profit.value();
    }

    public String getSellerId() {
        return sellerId.value();
    }

    public String getSellerCommissionStatus() {
        return sellerCommissionStatus.value();
    }
    public Date getSellerCommissionCreatedAt(){
        return createdAt.value();
    }
    public Date getSellerCommissionUpdatedAt(){
        return updatedAt.value();
    }

}
