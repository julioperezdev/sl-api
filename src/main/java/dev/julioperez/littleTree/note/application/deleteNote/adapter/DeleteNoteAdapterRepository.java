package dev.julioperez.littleTree.note.application.deleteNote.adapter;

import dev.julioperez.littleTree.note.domain.port.deleteNote.DeleteNoteOutputPort;
import dev.julioperez.littleTree.note.infrastructure.repository.dao.NoteDao;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DeleteNoteAdapterRepository implements DeleteNoteOutputPort {
    private final NoteDao noteDao;

    public DeleteNoteAdapterRepository(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    @Override
    public void deleteNoteById(String id) throws Exception{
        noteDao.deleteById(id);
    }
}
