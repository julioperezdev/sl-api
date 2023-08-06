package dev.julioperez.littleTree.infrastructure.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "OPERATION")
@Data
public class OperationEntity {
    //functional
    @Id
    private String uuid;
    @Column(name = "CREATED_AT")
    private Date createdAt;
    private String clientId;
    private String operationType;
}
