package models;
import java.util.Date;
import org.springframework.data.annotation.Id;

public class Note {
	
	@Id
	private String id;

	private User user;
	private String text;
	private Date date;
	
	//constructors
	public Note() {}
	
	public Note(String text, User user ) {
	    this.text = text;
	    this.date = new Date();
	    this.user = user;
	}
	//setters
	public void setUser(User user) {
		this.user = user;
	}
	public void setText(String text) {
		this.text = text;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	//getters
	public User getUser() {
		return user;
	}
	public String getText() {
		return text;
	}
	public Date getDate() {
		return date;
	}	

	@Override
    public String toString() {
        return String.format(
                "Note[ text='%s', date='%s', user='%s']",
                 this.getText(), this.getDate(), this.getUser());
    }
}
