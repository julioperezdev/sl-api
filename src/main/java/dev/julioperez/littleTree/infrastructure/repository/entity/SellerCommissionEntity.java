package dev.julioperez.littleTree.infrastructure.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "SELLER_COMMISSION")
@Data
public class SellerCommissionEntity {
    @Id
    private String uuid;
    private String sellerId;
    private String sellerCommissionStatus;
    private Float pesos;
    private Float quantity;
    private Float profit;
}
