package dev.julioperez.littleTree.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "SELLER_COMMISSION")
@Data
public class SellerCommission {
    @Id
    private String uuid;
    private String sellerId;
    private String sellerCommissionStatus;
    private Float pesos;
    private Float quantity;
    private Float profit;
}
