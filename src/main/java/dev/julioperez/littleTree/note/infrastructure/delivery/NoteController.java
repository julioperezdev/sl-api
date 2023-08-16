package dev.julioperez.littleTree.note.infrastructure.delivery;

import dev.julioperez.littleTree.client.domain.dto.CreateClientRequest;
import dev.julioperez.littleTree.client.domain.dto.UpdateClientRequest;
import dev.julioperez.littleTree.client.domain.model.Client;
import dev.julioperez.littleTree.note.domain.dto.CreateNoteRequest;
import dev.julioperez.littleTree.note.domain.dto.UpdateNoteRequest;
import dev.julioperez.littleTree.note.domain.model.Note;
import dev.julioperez.littleTree.note.domain.port.createNote.CreateNoteInputPort;
import dev.julioperez.littleTree.note.domain.port.deleteNote.DeleteNoteInputPort;
import dev.julioperez.littleTree.note.domain.port.getNote.GetNoteInputPort;
import dev.julioperez.littleTree.note.domain.port.updateNote.UpdateNoteInputPort;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/note")
@AllArgsConstructor
public class NoteController {
    private final GetNoteInputPort getNoteInputPort;
    private final CreateNoteInputPort createNoteInputPort;
    private final UpdateNoteInputPort updateNoteInputPort;
    private final DeleteNoteInputPort deleteNoteInputPort;
    @PostMapping("/create")
    public ResponseEntity<Note> createClient(@RequestBody CreateNoteRequest createNoteRequest) throws Exception{
        Note note = createNoteInputPort.createNote(createNoteRequest);
        return new ResponseEntity<>(note, HttpStatus.CREATED);
    }

    @PostMapping("/get")
    public ResponseEntity<List<Note>> getAllNotes() throws Exception {
        List<Note> notes = getNoteInputPort.getNotes();
        HttpStatus httpStatus = notes.isEmpty()
                ? HttpStatus.NO_CONTENT
                : HttpStatus.FOUND;
        return new ResponseEntity<>(notes, httpStatus);
    }

    @PutMapping("/update")
    public ResponseEntity<Note> updateNote(@RequestBody UpdateNoteRequest updateNoteRequest) throws Exception {
        Note note = updateNoteInputPort.updateNote(updateNoteRequest);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteNote(@PathVariable String id) throws Exception {
        boolean response = deleteNoteInputPort.deleteNoteById(id);
        HttpStatus httpStatus = response
                ? HttpStatus.ACCEPTED
                : HttpStatus.NOT_IMPLEMENTED;
        return new ResponseEntity<>(response, httpStatus);
    }
}
