package dev.julioperez.littleTree.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "MULTIBOX")
@Data
public class CurrencyMultiBox {
    //functional, i gonna be update, separate by currency
    @Id
    private String uuid;
    @Column(name = "CREATED_AT")
    private Date createdAt;
    @Column(name = "UPDATED_AT")
    private Date updatedAt;
    private String currencyBoxId;
    private String operationId;
    private Float quantity;
    private Float priceOperation;
    private String multiBoxStatusId;

}
