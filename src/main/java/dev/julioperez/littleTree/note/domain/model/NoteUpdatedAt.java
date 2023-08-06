package dev.julioperez.littleTree.note.domain.model;

import dev.julioperez.littleTree.shared.domain.model.DateValueObject;

import java.util.Date;

public final class NoteUpdatedAt extends DateValueObject {
    public NoteUpdatedAt(Date value) {
        super(value);
    }
}
