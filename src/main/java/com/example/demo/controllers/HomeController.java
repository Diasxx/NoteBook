package com.example.demo.controllers;

import com.example.demo.entities.Notes;
import com.example.demo.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private NoteService noteService;


    @GetMapping(value = "/")
    public String index(Model model){

        List<Notes> notes = noteService.getAllNotes();
        model.addAttribute("Notes",notes);

        return "index";
    }

    @PostMapping(value = "/addnote")
    public String addNote(@RequestParam(name = "note_title" ,defaultValue = "No Title") String title,
                          @RequestParam(name = "note_content" ,defaultValue = "No Content") String content){

        noteService.addNote(new Notes(null,title,content));

        return "redirect:/";
    }

    @PostMapping(value = "/deletenote")
    public String deleteNote(@RequestParam(name = "id") Long id){

        Notes note = noteService.getNote(id);

        if(note!=null){
            noteService.deleteNote(note);
        }
        return "redirect:/";
    }

    @GetMapping(value = "/update/{notes}")
    public String updateNote(Model model,@PathVariable(name = "notes") Long id )
    {
        Notes note = noteService.getNote(id);
        model.addAttribute("note",note);
        return "/update";
    }

    @PostMapping(value = "/updatenote")
    public String updateNote(@RequestParam(name = "id") Long id,
                             @RequestParam(name = "note_title" ,defaultValue = "No Title") String title,
                             @RequestParam(name = "note_content" ,defaultValue = "No Content") String content)
    {
        Notes  note = noteService.getNote(id);
        if(note!=null){
            note.setTitle(title);
            note.setText(content);
            noteService.saveNote(note);
        }
        return "redirect:/";
    }

}
