package dev.julioperez.littleTree.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "SELLER_BOX")
@Data
public class SellerBox {

    @Id
    private String uuid;
    private String balanceId;
}
