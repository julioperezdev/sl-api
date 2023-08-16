package dev.julioperez.littleTree.note.application.getNote.service;

import dev.julioperez.littleTree.note.domain.model.Note;
import dev.julioperez.littleTree.note.domain.port.getNote.GetNote;
import dev.julioperez.littleTree.note.domain.port.getNote.GetNoteOutputPort;

import java.util.List;
import java.util.Optional;

public class GetNoteService implements GetNote {
    private final GetNoteOutputPort getNoteOutputPort;

    public GetNoteService(GetNoteOutputPort getNoteOutputPort) {
        this.getNoteOutputPort = getNoteOutputPort;
    }

    @Override
    public List<Note> getNotes() {
        return getNoteOutputPort.getNotes();
    }

    @Override
    public Optional<Note> getNoteById(String id) {
        return getNotes().stream()
                .filter(note -> note.getId().equals(id))
                .findFirst();
    }
}
