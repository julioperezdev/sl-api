package dev.julioperez.littleTree.operation.infrastructure.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "OPERATION")
@Data
public class OperationEntity {
    //functional
    @Id
    private String id;
    @Column(name = "CREATED_AT")
    private Date createdAt;
    private String clientId;
    private String operationType;
}
