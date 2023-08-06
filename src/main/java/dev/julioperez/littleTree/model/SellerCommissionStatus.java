package dev.julioperez.littleTree.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "SELLER_COMMISSION_STATUS")
@Data
public class SellerCommissionStatus {
    @Id
    private String uuid;
    private String description;
}
