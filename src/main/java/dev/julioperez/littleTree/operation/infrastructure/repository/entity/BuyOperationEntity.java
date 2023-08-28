package dev.julioperez.littleTree.operation.infrastructure.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "BUY_OPERATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyOperationEntity {

    @Id
    private String id;
    @Column(name = "CREATED_AT", nullable = false)
    private Date createdAt;
    private String clientId;
    private String phone;
    private String currencyMultiBox;
    private Float price;
    private Float quantity;
    private Float percent;
    private Float total;
    private Boolean officeCheck;
    private String operationStatus;
    private Float reserve;
}
