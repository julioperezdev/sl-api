package dev.julioperez.littleTree.note.domain.port.getNote;

import dev.julioperez.littleTree.note.domain.model.Note;

import java.util.List;

public interface GetNoteInputPort {
    List<Note> getNotes();
}
