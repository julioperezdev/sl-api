package dev.julioperez.littleTree.note.infrastructure.repository.dao;

import dev.julioperez.littleTree.note.infrastructure.repository.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteDao extends JpaRepository<NoteEntity, String> {
}
