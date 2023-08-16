package dev.julioperez.littleTree.note.application.updateNote.service;

import dev.julioperez.littleTree.note.domain.dto.UpdateNoteRequest;
import dev.julioperez.littleTree.note.domain.model.Note;
import dev.julioperez.littleTree.note.domain.port.getNote.GetNote;
import dev.julioperez.littleTree.note.domain.port.mapper.NoteMapper;
import dev.julioperez.littleTree.note.domain.port.updateNote.UpdateNote;
import dev.julioperez.littleTree.note.domain.port.updateNote.UpdateNoteOutputPort;

import java.util.Optional;

public class UpdateNoteService implements UpdateNote {
    private final UpdateNoteOutputPort updateNoteOutputPort;
    private final GetNote getNote;
    private final NoteMapper noteMapper;

    public UpdateNoteService(UpdateNoteOutputPort updateNoteOutputPort, GetNote getNote, NoteMapper noteMapper) {
        this.updateNoteOutputPort = updateNoteOutputPort;
        this.getNote = getNote;
        this.noteMapper = noteMapper;
    }

    @Override
    public Note updateNote(UpdateNoteRequest updateNoteRequest) {
        Optional<Note> noteById = getNote.getNoteById(updateNoteRequest.id());
        if(noteById.isEmpty()) throw new IllegalArgumentException(String.format("%s value dont exist as Note", updateNoteRequest.id()));
        Note noteToUpdate = noteMapper.toNoteModel(noteById.get(), updateNoteRequest);
        return updateNoteOutputPort.updateNote(noteToUpdate);
    }
}
