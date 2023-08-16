package dev.julioperez.littleTree.note.domain.port.createNote;

import dev.julioperez.littleTree.note.domain.dto.CreateNoteRequest;
import dev.julioperez.littleTree.note.domain.model.Note;

public interface CreateNote {
    Note createNote(CreateNoteRequest createNoteRequest);
}
