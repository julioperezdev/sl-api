package dev.julioperez.littleTree.note.application.createNote.delivery;

import dev.julioperez.littleTree.note.domain.dto.CreateNoteRequest;
import dev.julioperez.littleTree.note.domain.model.Note;
import dev.julioperez.littleTree.note.domain.port.createNote.CreateNote;
import dev.julioperez.littleTree.note.domain.port.createNote.CreateNoteInputPort;

public class CreateNoteDelivery implements CreateNoteInputPort {
    private final CreateNote createNote;

    public CreateNoteDelivery(CreateNote createNote) {
        this.createNote = createNote;
    }

    @Override
    public Note createNote(CreateNoteRequest createNoteRequest) {
        return createNote.createNote(createNoteRequest);
    }
}
