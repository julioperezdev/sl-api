package dev.julioperez.littleTree.note.domain.model;

import dev.julioperez.littleTree.shared.domain.model.DateValueObject;

import java.util.Date;

public final class NoteCreatedAt extends DateValueObject {
    public NoteCreatedAt(Date value) {
        super(value);
    }
}
