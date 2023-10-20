package com.example.demo.services;

import com.example.demo.entities.Notes;

import java.util.List;

public interface NoteService {

    Notes addNote(Notes note);
    List<Notes> getAllNotes();
    Notes getNote(Long id);
    void deleteNote(Notes note);
    Notes saveNote(Notes note);

}
