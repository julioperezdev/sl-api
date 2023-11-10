package dev.julioperez.littleTree.seller.infrastructure.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "SELLER_COMMISSION", schema = "SL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerCommissionEntity {
    @Id
    private String id;
    private String sellerId;
    private String sellerCommissionStatus;
    private String operationId;
    private Float total;
    private Float profit;
    private Float quantity;
    private Float pesos;
    private Date createdAt;
    private Date updatedAt;
}
