package dev.julioperez.littleTree.note.application.deleteNote.delivery;

import dev.julioperez.littleTree.note.domain.port.deleteNote.DeleteNote;
import dev.julioperez.littleTree.note.domain.port.deleteNote.DeleteNoteInputPort;

public class DeleteNoteDelivery implements DeleteNoteInputPort {
    private final DeleteNote deleteNote;

    public DeleteNoteDelivery(DeleteNote deleteNote) {
        this.deleteNote = deleteNote;
    }

    @Override
    public boolean deleteNoteById(String id) {
        return deleteNote.deleteNoteById(id);
    }
}
