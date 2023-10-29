package dev.julioperez.littleTree.box.infrastructure.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "BALANCE", schema = "SL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalanceEntity {

    @Id
    private String id;
    private Float profit;
    private String operationId;
    private Date createdAt;
    private Date updatedAt;
    private String operationType;
    private Float quantityOperation;
}
