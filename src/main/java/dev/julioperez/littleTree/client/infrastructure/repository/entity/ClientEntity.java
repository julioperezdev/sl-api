package dev.julioperez.littleTree.client.infrastructure.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "CLIENT", schema = "SL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntity {

    @Id
    private String id;
    private String name;
    private String phone;
    private String address;
    private String description;
    private Date createdAt;
    private Date updatedAt;
}
