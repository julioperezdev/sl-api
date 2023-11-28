package dev.julioperez.littleTree.box.currencyBox.shared.infrastructure.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "MULTIBOX", schema = "SL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyMultiBoxEntity {

    @Id
    private String id;
    private Date createdAt;
    private Date updatedAt;
    private String currencyBox;
    private String operationId;
    private String operationType;
    private Float quantity;
    private Float quantityOperation;
    private String multiBoxStatus;
    private Float quantityChanged;

}
