package dev.julioperez.littleTree.box.infrastructure.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BALANCE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalanceEntity {

    @Id
    private String id;
    private Float profit;
    private String operationId;
}
