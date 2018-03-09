package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import models.Note;
import models.User;


@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;	
	
	@Autowired
	private NoteRepository noteRepository;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
		
	@Override
	public void run(String... args) throws Exception {
		noteRepository.deleteAll();
		userRepository.deleteAll();

		// save a couple of users
		userRepository.save(new User("Alice"));
		userRepository.save(new User("Termight"));

		// show all users
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (User user : userRepository.findAll()) {
			System.out.println(user);
		}
		System.out.println();
		
		
		// fetch an individual user
		
		System.out.println("user found with findByUserName('Alice'):");
		System.out.println("--------------------------------");
		User Alice = userRepository.findByUserName("Alice");
		System.out.println(Alice);
		System.out.println();
		
		
		//Save notes
		User Termight = userRepository.findByUserName("Termight");
		
		noteRepository.save(new Note("my note 1",Alice));
		noteRepository.save(new Note("My note 2",Alice));
		noteRepository.save(new Note("Note 3",Alice));
		noteRepository.save(new Note("Note 4",Alice));
		noteRepository.save(new Note("this is the first note of termight",Termight)); 
		
		System.out.println();
		System.out.println();
		//Show all notes

		
		//Show all users again:
		System.out.println("Notes found with findAll():");
		System.out.println("-------------------------------");
		for (Note note : noteRepository.findAll()) {
			System.out.println(note);
		}
		System.out.println();
		
		System.out.println("Notes found with findByUserUserName(Alice):");
		System.out.println("-------------------------------");
		for (Note note : noteRepository.findByUserUserName("Alice")) {
			System.out.println(note);
		}

		System.out.println("Notes found with findByUserUserName(alice):");
		System.out.println("-------------------------------");
		for (Note note : noteRepository.findByUserUserName("alice")) {
			System.out.println(note);
		}
		
		
	}

}
