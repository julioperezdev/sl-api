package dev.julioperez.littleTree.box.infrastructure.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "MULTIBOX")
@Data
public class CurrencyMultiBoxEntity {

    @Id
    private String id;
    @Column(name = "CREATED_AT")
    private Date createdAt;
    @Column(name = "UPDATED_AT")
    private Date updatedAt;
    private String currencyBox;
    private String operationId;
    private Float quantity;
    private Float priceOperation;
    private String multiBoxStatus;

}
