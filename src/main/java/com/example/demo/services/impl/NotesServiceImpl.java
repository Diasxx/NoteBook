package com.example.demo.services.impl;

import com.example.demo.entities.Notes;
import com.example.demo.repositories.NoteRepository;
import com.example.demo.services.NoteService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NotesServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    public NotesServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Notes addNote(Notes note) {
        return noteRepository.save(note);
    }

    @Override
    public List<Notes> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Notes getNote(Long id) {
        return noteRepository.getOne(id);
    }

    @Override
    public void deleteNote(Notes note) {
        noteRepository.delete(note);
    }

    @Override
    public Notes saveNote(Notes note) {
        return noteRepository.save(note);
    }
}
