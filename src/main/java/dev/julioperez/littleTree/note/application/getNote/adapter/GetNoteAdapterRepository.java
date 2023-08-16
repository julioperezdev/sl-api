package dev.julioperez.littleTree.note.application.getNote.adapter;

import dev.julioperez.littleTree.note.domain.model.Note;
import dev.julioperez.littleTree.note.domain.port.getNote.GetNoteOutputPort;
import dev.julioperez.littleTree.note.domain.port.mapper.NoteMapper;
import dev.julioperez.littleTree.note.infrastructure.repository.dao.NoteDao;
import dev.julioperez.littleTree.note.infrastructure.repository.entity.NoteEntity;

import java.util.List;

public class GetNoteAdapterRepository implements GetNoteOutputPort {
    private final NoteDao noteDao;
    private final NoteMapper noteMapper;

    public GetNoteAdapterRepository(NoteDao noteDao, NoteMapper noteMapper) {
        this.noteDao = noteDao;
        this.noteMapper = noteMapper;
    }

    @Override
    public List<Note> getNotes() {
        List<NoteEntity> noteEntities = noteDao.findAll();
        return noteMapper.toNotesModel(noteEntities);
    }
}
