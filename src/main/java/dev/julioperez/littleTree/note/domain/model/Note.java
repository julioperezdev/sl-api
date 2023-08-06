package dev.julioperez.littleTree.note.domain.model;

public final class Note {

    private final NoteId id;
    private final NoteDescription description;
    private final NoteColor color;
    private final NoteCreatedAt createdAt;
    private final NoteUpdatedAt updatedAt;

    public Note(NoteId id, NoteDescription description, NoteColor color, NoteCreatedAt createdAt, NoteUpdatedAt updatedAt) {
        this.id = id;
        this.description = description;
        this.color = color;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
