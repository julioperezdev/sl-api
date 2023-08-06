package dev.julioperez.littleTree.box.infrastructure.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "BALANCE")
@Data
public class BalanceEntity {

    @Id
    private String id;
    private Float profit;
    private String operationId;
}
