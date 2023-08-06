package dev.julioperez.littleTree.infrastructure.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "SELLER_BOX")
@Data
public class SellerBoxEntity {

    @Id
    private String uuid;
    private String balanceId;
}
