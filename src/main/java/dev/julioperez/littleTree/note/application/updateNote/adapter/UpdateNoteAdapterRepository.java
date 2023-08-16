package dev.julioperez.littleTree.note.application.updateNote.adapter;

import dev.julioperez.littleTree.note.domain.model.Note;
import dev.julioperez.littleTree.note.domain.port.mapper.NoteMapper;
import dev.julioperez.littleTree.note.domain.port.updateNote.UpdateNoteOutputPort;
import dev.julioperez.littleTree.note.infrastructure.repository.dao.NoteDao;
import dev.julioperez.littleTree.note.infrastructure.repository.entity.NoteEntity;

public class UpdateNoteAdapterRepository implements UpdateNoteOutputPort {
    private final NoteDao noteDao;
    private final NoteMapper noteMapper;

    public UpdateNoteAdapterRepository(NoteDao noteDao, NoteMapper noteMapper) {
        this.noteDao = noteDao;
        this.noteMapper = noteMapper;
    }

    @Override
    public Note updateNote(Note note) {
        NoteEntity noteEntity = noteMapper.toNoteEntity(note);
        noteDao.save(noteEntity);
        return noteMapper.toNoteModel(noteEntity);
    }
}
