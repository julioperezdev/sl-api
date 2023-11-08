package dev.julioperez.littleTree.box.sellerbox.infrastructure.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "SELLER_BOX", schema = "SL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerBoxEntity {

    @Id
    private String id;
    private Float quantity;
    private Float quantityOperation;
    private String name;
    private String operationType;
    private Date createdAt;
    private Date updatedAt;
}
