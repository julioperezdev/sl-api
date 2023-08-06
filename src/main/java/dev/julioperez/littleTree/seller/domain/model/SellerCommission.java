package dev.julioperez.littleTree.seller.domain.model;

import dev.julioperez.littleTree.seller.domain.enums.SellerCommissionStatus;

public final class SellerCommission {
    private final SellerCommissionId id;
    private final SellerCommissionPesos pesos;
    private final SellerCommissionQuantity quantity;
    private final SellerCommissionProfit profit;
    private final SellerId sellerId;
    private final SellerCommissionStatus sellerCommissionStatus;

    public SellerCommission(SellerCommissionId id, SellerCommissionPesos pesos, SellerCommissionQuantity quantity, SellerCommissionProfit profit, SellerId sellerId, SellerCommissionStatus sellerCommissionStatus) {
        this.id = id;
        this.pesos = pesos;
        this.quantity = quantity;
        this.profit = profit;
        this.sellerId = sellerId;
        this.sellerCommissionStatus = sellerCommissionStatus;
    }
}
