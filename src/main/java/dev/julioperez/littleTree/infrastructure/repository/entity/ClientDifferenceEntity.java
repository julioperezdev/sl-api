package dev.julioperez.littleTree.infrastructure.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "CLIENT_DIFFERENCE")
@Data
public class ClientDifferenceEntity {

    @Id
    private String uuid;
    @Column(name = "CREATED_AT", nullable = false)
    private Date createdAt;
    private String clientId;
    private Float amount;
    private String description;
    private String differenceType;
    private String differenceStatus;

}
