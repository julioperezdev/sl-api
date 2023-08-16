package dev.julioperez.littleTree.note.application.createNote.service;

import dev.julioperez.littleTree.note.domain.dto.CreateNoteRequest;
import dev.julioperez.littleTree.note.domain.model.Note;
import dev.julioperez.littleTree.note.domain.port.createNote.CreateNote;
import dev.julioperez.littleTree.note.domain.port.createNote.CreateNoteOutputPort;
import dev.julioperez.littleTree.note.domain.port.mapper.NoteMapper;

public class CreateNoteService implements CreateNote {
    private final CreateNoteOutputPort createNoteOutputPort;
    private final NoteMapper noteMapper;

    public CreateNoteService(CreateNoteOutputPort createNoteOutputPort, NoteMapper noteMapper) {
        this.createNoteOutputPort = createNoteOutputPort;
        this.noteMapper = noteMapper;
    }

    @Override
    public Note createNote(CreateNoteRequest createNoteRequest) {
        Note noteToCreate = noteMapper.toNoteModel(createNoteRequest);
        return createNoteOutputPort.createNote(noteToCreate);
    }
}
