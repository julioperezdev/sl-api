package dev.julioperez.littleTree.note.domain.model;

import java.util.Date;

public final class Note {

    private final NoteId id;
    private final NoteDescription description;
    private final NoteColor color;
    private final NoteCreatedAt createdAt;
    private final NoteUpdatedAt updatedAt;

    public Note(String id, String description, String color, Date createdAt, Date updatedAt) {
        this.id = new NoteId(id);
        this.description = new NoteDescription(description);
        this.color = new NoteColor(color);
        this.createdAt = new NoteCreatedAt(createdAt);
        this.updatedAt = new NoteUpdatedAt(updatedAt);
    }

    public String getId() {
        return id.value();
    }

    public String getDescription() {
        return description.value();
    }

    public String getColor() {
        return color.value();
    }

    public Date getCreatedAt() {
        return createdAt.value();
    }

    public Date getUpdatedAt() {
        return updatedAt.value();
    }
}
