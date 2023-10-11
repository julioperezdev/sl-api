package dev.julioperez.littleTree.box.infrastructure.repository.entity;

import io.swagger.v3.oas.annotations.media.Schema;
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
    private String balanceId;
    private String name;
    private String description;
    private Date createdAt;
    private Date updatedAt;
}
