package dev.julioperez.littleTree.note.application.modelMapper;

import dev.julioperez.littleTree.note.domain.dto.CreateNoteRequest;
import dev.julioperez.littleTree.note.domain.dto.UpdateNoteRequest;
import dev.julioperez.littleTree.note.domain.model.Note;
import dev.julioperez.littleTree.note.domain.port.mapper.NoteMapper;
import dev.julioperez.littleTree.note.infrastructure.repository.entity.NoteEntity;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class NoteModelMapper implements NoteMapper {
    @Override
    public Note toNoteModel(CreateNoteRequest createNoteRequest) {
        return new Note(
                //UUID.randomUUID().toString(),
                createNoteRequest.id(),
                createNoteRequest.description(),
                createNoteRequest.color(),
                Date.from(Instant.now()),
                Date.from(Instant.now()));
    }

    @Override
    public Note toNoteModel(Note note, UpdateNoteRequest updateNoteRequest) {
        return new Note(
                note.getId(),
                updateNoteRequest.description(),
                updateNoteRequest.color(),
                note.getCreatedAt(),
                Date.from(Instant.now()));
    }

    @Override
    public Note toNoteModel(NoteEntity noteEntity) {
        return new Note(
                noteEntity.getId(),
                noteEntity.getDescription(),
                noteEntity.getColor(),
                noteEntity.getCreatedAt(),
                noteEntity.getUpdatedAt());
    }

    @Override
    public List<Note> toNotesModel(List<NoteEntity> noteEntities) {
        return noteEntities
                .stream()
                .map(this::toNoteModel)
                .toList();
    }

    @Override
    public NoteEntity toNoteEntity(Note note) {
        return new NoteEntity(
                note.getId(),
                note.getDescription(),
                note.getColor(),
                note.getCreatedAt(),
                note.getUpdatedAt());
    }
}
