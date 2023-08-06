package dev.julioperez.littleTree.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "DIFFERENCE_STATUS")
@Data
public class DifferenceStatus {

    @Id
    private String uuid;
    private String description;
}
