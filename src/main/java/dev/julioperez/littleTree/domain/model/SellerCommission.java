package dev.julioperez.littleTree.domain.model;

import dev.julioperez.littleTree.domain.enums.SellerCommissionStatus;
import java.util.UUID;

public class SellerCommission {

    private UUID uuid;
    private UUID sellerId;
    private SellerCommissionStatus sellerCommissionStatus;
    private Float pesos;
    private Float quantity;
    private Float profit;
}
