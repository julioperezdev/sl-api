package dev.julioperez.littleTree.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "OPERATION_TYPE")
@Data
public class OperationType {
    //constant info
    @Id
    private String uuid;
    private String name;
}
