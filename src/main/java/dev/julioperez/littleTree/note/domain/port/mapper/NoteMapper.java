package dev.julioperez.littleTree.note.domain.port.mapper;

import dev.julioperez.littleTree.currency.domain.dto.UpdateCurrencyRequest;
import dev.julioperez.littleTree.currency.domain.model.Currency;
import dev.julioperez.littleTree.currency.infrastructure.repository.entity.CurrencyEntity;
import dev.julioperez.littleTree.note.domain.dto.CreateNoteRequest;
import dev.julioperez.littleTree.note.domain.dto.UpdateNoteRequest;
import dev.julioperez.littleTree.note.domain.model.Note;
import dev.julioperez.littleTree.note.infrastructure.repository.entity.NoteEntity;

import java.util.List;

public interface NoteMapper {
    Note toNoteModel(CreateNoteRequest createNoteRequest);
    Note toNoteModel(Note note, UpdateNoteRequest updateNoteRequest);
    Note toNoteModel(NoteEntity noteEntity);
    List<Note> toNotesModel(List<NoteEntity> noteEntities);
    NoteEntity toNoteEntity(Note note);
}
