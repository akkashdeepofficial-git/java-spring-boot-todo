package org.example.demotodo.repository;

import org.example.demotodo.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepo extends JpaRepository<Notes,Long>{

}