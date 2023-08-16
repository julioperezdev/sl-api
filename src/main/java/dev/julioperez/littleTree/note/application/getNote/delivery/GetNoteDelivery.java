package dev.julioperez.littleTree.note.application.getNote.delivery;

import dev.julioperez.littleTree.note.domain.model.Note;
import dev.julioperez.littleTree.note.domain.port.getNote.GetNote;
import dev.julioperez.littleTree.note.domain.port.getNote.GetNoteInputPort;

import java.util.List;

public class GetNoteDelivery implements GetNoteInputPort {
    private final GetNote getNote;

    public GetNoteDelivery(GetNote getNote) {
        this.getNote = getNote;
    }

    @Override
    public List<Note> getNotes() {
        return getNote.getNotes();
    }
}
