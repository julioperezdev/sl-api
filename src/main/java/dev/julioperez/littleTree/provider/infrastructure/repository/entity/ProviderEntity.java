package dev.julioperez.littleTree.provider.infrastructure.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "PROVIDER")
@Data
public class ProviderEntity {

    @Id
    private String id;
    private String name;
    private String phone;
    private String address;
    @Column(name = "CREATED_AT", nullable = false)
    private Date createdAt;
}
