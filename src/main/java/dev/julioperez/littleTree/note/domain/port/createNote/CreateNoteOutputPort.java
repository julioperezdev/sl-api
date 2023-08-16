package dev.julioperez.littleTree.note.domain.port.createNote;


import dev.julioperez.littleTree.note.domain.model.Note;

public interface CreateNoteOutputPort {
    Note createNote(Note note);
}
