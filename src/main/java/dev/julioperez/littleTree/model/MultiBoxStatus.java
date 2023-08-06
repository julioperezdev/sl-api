package dev.julioperez.littleTree.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "MULTI_BOX_STATUS")
@Data
public class MultiBoxStatus {
    @Id
    private String uuid;
    private String description;
}
