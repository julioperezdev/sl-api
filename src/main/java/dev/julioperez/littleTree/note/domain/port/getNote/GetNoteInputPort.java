package dev.julioperez.littleTree.note.domain.port.getNote;

import dev.julioperez.littleTree.note.domain.model.Note;

import java.util.List;
import java.util.Optional;

public interface GetNoteInputPort {
    List<Note> getNotes();
    Optional<Note> getNoteById(String id);
}
