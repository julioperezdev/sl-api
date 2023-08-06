package dev.julioperez.littleTree.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "SELLER_OPERATION")
@Data
public class SellOperation {
    @Id
    private String uuid;
    @Column(name = "CREATED_AT", nullable = false)
    private Date createdAt;
    private String clientId;
    private String phone;
    private String description;
    private String currencyMultiBoxId;
    private Float price;
    private Float quantity;
    private Float subProfit;
    private Float profit;
    private Float total;
    private String sellerId;
    private String operationId;
}
