package org.example.demotodo.controller;


import org.example.demotodo.entity.Notes;
import org.example.demotodo.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {


    @Autowired
    private NoteService noteService;


    @GetMapping
    public List<Notes> getAllNotes(){
        return noteService.getAllNotes();

    }

    @PostMapping
    public Notes createNotes(@RequestBody Notes notes){

        return noteService.saveNote(notes);
    }

    @DeleteMapping("/{id}")
    public String deleteNotes(@PathVariable Long id){
        noteService.delNotes(id);
        return "Deleted Successfully";
    }

    @PutMapping("{id}")
    public String updateNotes(@PathVariable Long id, @RequestBody Notes notes){
        noteService.updateNotes(id,notes);
        return "Updated Successfully";
    }
}
