package dev.julioperez.littleTree.note.infrastructure.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "NOTE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteEntity {

    @Id
    private String id;
    private String description;
    private String color;
    @Column(name = "CREATED_AT", nullable = false)
    private Date createdAt;
    @Column(name = "UPDATED_AT", nullable = false)
    private Date updatedAt;
}
