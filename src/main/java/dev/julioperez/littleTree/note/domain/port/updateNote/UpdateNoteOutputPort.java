package dev.julioperez.littleTree.note.domain.port.updateNote;

import dev.julioperez.littleTree.note.domain.dto.UpdateNoteRequest;
import dev.julioperez.littleTree.note.domain.model.Note;

public interface UpdateNoteOutputPort {
    Note updateNote(Note note);
}
