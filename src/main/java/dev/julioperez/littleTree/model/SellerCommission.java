package dev.julioperez.littleTree.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "SELLER_COMMISSION")
@Data
public class SellerCommission {
    @Id
    private String uuid;
    private String sellerId;
    private String sellerCommissionStatusId;
    private Float pesos;
    private Float quantity;
    private Float profit;
}
