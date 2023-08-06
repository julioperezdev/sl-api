package dev.julioperez.littleTree.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "OPERATION")
@Data
public class Operation {
    //functional
    @Id
    private String uuid;
    @Column(name = "CREATED_AT")
    private Date createdAt;
    private String clientId;
    private String operationType;
}
