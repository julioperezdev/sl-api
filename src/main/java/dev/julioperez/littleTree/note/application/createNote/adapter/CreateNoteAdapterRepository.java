package dev.julioperez.littleTree.note.application.createNote.adapter;

import dev.julioperez.littleTree.note.domain.model.Note;
import dev.julioperez.littleTree.note.domain.port.createNote.CreateNoteOutputPort;
import dev.julioperez.littleTree.note.domain.port.mapper.NoteMapper;
import dev.julioperez.littleTree.note.infrastructure.repository.dao.NoteDao;
import dev.julioperez.littleTree.note.infrastructure.repository.entity.NoteEntity;

public class CreateNoteAdapterRepository implements CreateNoteOutputPort {
    private final NoteDao noteDao;
    private final NoteMapper noteMapper;

    public CreateNoteAdapterRepository(NoteDao noteDao, NoteMapper noteMapper) {
        this.noteDao = noteDao;
        this.noteMapper = noteMapper;
    }

    @Override
    public Note createNote(Note note) {
        NoteEntity noteEntity = noteMapper.toNoteEntity(note);
        noteDao.save(noteEntity);
        return noteMapper.toNoteModel(noteEntity);
    }
}
