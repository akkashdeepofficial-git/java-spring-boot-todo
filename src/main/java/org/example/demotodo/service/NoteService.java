package org.example.demotodo.service;


import org.example.demotodo.entity.Notes;
import org.example.demotodo.repository.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepo noteRepo;

    public List<Notes> getAllNotes(){
        return noteRepo.findAll();
    }

    public Notes saveNote(Notes notes) {
        return noteRepo.save(notes);
    }

    public void delNotes(Long id) {
        noteRepo.deleteById(id);
    }

    public Notes updateNotes(Long id, Notes notes) {

        Notes existingNotes = noteRepo.findById(id).orElse(null);

        if(existingNotes !=null){
            existingNotes.setTitle(notes.getTitle());
            existingNotes.setContent(notes.getContent());

            return noteRepo.save(existingNotes);
        }
        return null;
    }
}
