package dev.julioperez.littleTree.note.application.deleteNote.service;

import dev.julioperez.littleTree.note.domain.port.deleteNote.DeleteNote;
import dev.julioperez.littleTree.note.domain.port.deleteNote.DeleteNoteOutputPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DeleteNoteService implements DeleteNote {
    private final DeleteNoteOutputPort deleteNoteOutputPort;

    public DeleteNoteService(DeleteNoteOutputPort deleteNoteOutputPort) {
        this.deleteNoteOutputPort = deleteNoteOutputPort;
    }

    @Override
    public boolean deleteNoteById(String id) {
        boolean result = false;
        try{
            deleteNoteOutputPort.deleteNoteById(id);
            result = true;
        }catch (Exception exception){
            log.error("Error on deleteNoteById", exception);
        }
        return result;
    }
}
