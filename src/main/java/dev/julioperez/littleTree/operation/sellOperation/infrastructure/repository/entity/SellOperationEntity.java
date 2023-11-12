package dev.julioperez.littleTree.operation.sellOperation.infrastructure.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "SELL_OPERATION", schema = "SL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellOperationEntity {
    @Id
    private String id;
    private Date createdAt;
    private Date updatedAt;
    private String clientId;
    private String currencyMultiBox;
    private Float price;
    private Float quantity;
    private Float subProfit;
    private Float profit;
    private Float total;
    private String sellerId;
    private String operationStatus;
    private Float sellerProfit;
}
