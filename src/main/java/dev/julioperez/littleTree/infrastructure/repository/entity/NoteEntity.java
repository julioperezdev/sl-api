package dev.julioperez.littleTree.infrastructure.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "NOTE")
@Data
public class NoteEntity {

    @Id
    private String uuid;
    private String description;
    private String color;
    @Column(name = "CREATED_AT", nullable = false)
    private Date createdAt;
    @Column(name = "UPDATED_AT", nullable = false)
    private Date updatedAt;
}
