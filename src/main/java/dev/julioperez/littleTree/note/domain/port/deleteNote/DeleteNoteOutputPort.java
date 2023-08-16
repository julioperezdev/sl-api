package dev.julioperez.littleTree.note.domain.port.deleteNote;

public interface DeleteNoteOutputPort {
    void deleteNoteById(String id) throws Exception;
}
