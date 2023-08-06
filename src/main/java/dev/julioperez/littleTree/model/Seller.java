package dev.julioperez.littleTree.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "SELLER")
@Data
public class Seller {

    @Id
    private String uuid;
    private String name;
    private String phone;
}
