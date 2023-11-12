package dev.julioperez.littleTree.operation.buyOperation.infrastructure.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "BUY_OPERATION", schema = "SL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyOperationEntity {

    @Id
    private String id;
    private Date createdAt;
    private Date updatedAt;
    private String clientId;
    private String currencyMultiBox;
    private Float price;
    private Float quantity;
    private Float percent;
    private Float total;
    private Boolean officeCheck;
    private String operationStatus;
    private Float reserve;
}
