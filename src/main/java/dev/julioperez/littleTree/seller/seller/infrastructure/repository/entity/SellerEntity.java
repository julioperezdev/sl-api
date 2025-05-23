package dev.julioperez.littleTree.seller.seller.infrastructure.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "SELLER", schema = "SL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerEntity {
    @Id
    private String id;
    private String name;
    private String phone;
    private String description;
    private Date createdAt;
    private Date updatedAt;
}
