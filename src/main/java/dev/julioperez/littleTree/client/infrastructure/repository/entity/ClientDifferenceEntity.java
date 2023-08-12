package dev.julioperez.littleTree.client.infrastructure.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "CLIENT_DIFFERENCE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDifferenceEntity {

    @Id
    private String id;
    @Column(name = "CREATED_AT", nullable = false)
    private Date createdAt;
    private String clientId;
    private Float amount;
    private String description;
    private String differenceType;
    private String differenceStatus;

}
