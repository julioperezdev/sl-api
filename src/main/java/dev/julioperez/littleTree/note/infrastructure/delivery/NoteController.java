package dev.julioperez.littleTree.note.infrastructure.delivery;

import dev.julioperez.littleTree.note.domain.dto.CreateNoteRequest;
import dev.julioperez.littleTree.note.domain.dto.UpdateNoteRequest;
import dev.julioperez.littleTree.note.domain.model.Note;
import dev.julioperez.littleTree.note.domain.port.createNote.CreateNoteInputPort;
import dev.julioperez.littleTree.note.domain.port.deleteNote.DeleteNoteInputPort;
import dev.julioperez.littleTree.note.domain.port.getNote.GetNoteInputPort;
import dev.julioperez.littleTree.note.domain.port.updateNote.UpdateNoteInputPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/note")
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:3001")
public class NoteController {
    private final GetNoteInputPort getNoteInputPort;
    private final CreateNoteInputPort createNoteInputPort;
    private final UpdateNoteInputPort updateNoteInputPort;
    private final DeleteNoteInputPort deleteNoteInputPort;
    @PutMapping("/create")
    public ResponseEntity<Note> createClient(@RequestBody CreateNoteRequest createNoteRequest) throws Exception{
        Note note = createNoteInputPort.createNote(createNoteRequest);
        return new ResponseEntity<>(note, HttpStatus.CREATED);
    }

    @PutMapping("/get")
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> notes = getNoteInputPort.getNotes();
        HttpStatus httpStatus = notes.isEmpty()
                ? HttpStatus.NO_CONTENT
                : HttpStatus.FOUND;
        return new ResponseEntity<>(notes, httpStatus);
    }

    @PutMapping("/get/{id}")
    public ResponseEntity<Optional<Note>> getNoteById(@PathVariable String id){
        Optional<Note> notes = getNoteInputPort.getNoteById(id);
        HttpStatus httpStatus = notes.isEmpty()
                ? HttpStatus.NO_CONTENT
                : HttpStatus.FOUND;
        return new ResponseEntity<>(notes, httpStatus);
    }

    @PutMapping("/update")
    public ResponseEntity<Note> updateNote(@RequestBody UpdateNoteRequest updateNoteRequest) {
        Note note = updateNoteInputPort.updateNote(updateNoteRequest);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteNote(@PathVariable String id){
        boolean response = deleteNoteInputPort.deleteNoteById(id);
        HttpStatus httpStatus = response
                ? HttpStatus.ACCEPTED
                : HttpStatus.NOT_IMPLEMENTED;
        return new ResponseEntity<>(response, httpStatus);
    }
}
