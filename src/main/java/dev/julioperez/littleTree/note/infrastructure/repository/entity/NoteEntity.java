package dev.julioperez.littleTree.note.infrastructure.repository.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "NOTE", schema = "SL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteEntity {

    @Id
    private String id;
    private String description;
    private String color;
    private Date createdAt;
    private Date updatedAt;
}
