package com.example.demo.services.impl;

import com.example.demo.entities.Notes;
import com.example.demo.repositories.NoteRepository;
import com.example.demo.services.NoteService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Service
public class NotesServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

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
