package app;

import org.springframework.data.mongodb.repository.MongoRepository;

import models.Note;
import models.User;

import java.util.List;

public interface NoteRepository extends MongoRepository <Note, String>{
	
    public Note findByText(String text);
    public Note findByUser(User user);
    public List<Note> findAll();
    public List<Note> findByUserUserName(String userName);
    
} 