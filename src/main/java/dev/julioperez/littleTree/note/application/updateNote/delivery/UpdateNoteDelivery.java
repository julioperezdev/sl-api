package dev.julioperez.littleTree.note.application.updateNote.delivery;

import dev.julioperez.littleTree.note.domain.dto.UpdateNoteRequest;
import dev.julioperez.littleTree.note.domain.model.Note;
import dev.julioperez.littleTree.note.domain.port.updateNote.UpdateNote;
import dev.julioperez.littleTree.note.domain.port.updateNote.UpdateNoteInputPort;

import java.util.Optional;

public class UpdateNoteDelivery implements UpdateNoteInputPort {

    private final UpdateNote updateNote;

    public UpdateNoteDelivery(UpdateNote updateNote) {
        this.updateNote = updateNote;
    }

    @Override
    public Note updateNote(UpdateNoteRequest updateNoteRequest) {
        return updateNote.updateNote(updateNoteRequest);
    }
}
