package dev.julioperez.littleTree.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "CLIENT_DIFFERENCE")
@Data
public class ClientDifference {

    @Id
    private String uuid;
    @Column(name = "CREATED_AT", nullable = false)
    private Date createdAt;
    private String clientId;
    private Float amount;
    private String description;
    private String differenceTypeId;
    private String differenceStatusId;

}
