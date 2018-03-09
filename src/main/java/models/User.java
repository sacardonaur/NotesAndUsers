package models;


import org.springframework.data.annotation.Id;


public class User {
	
	@Id	
	public String id;
	
	private String userName;

	

	//constructors
	public User() {
	}
	public User(String userName) {
		this.userName = userName;		
	}

	//Getters
	public String getUserName() {
		return userName;
	}
	public String getId() {
		return id;
	}

	//Setters
	 public void setUserName(String userName) {
		this.userName = userName;
	}

	//remember to correct this to string, it will just show a direction of the notes
	@Override
    public String toString() {
        return String.format(
                "User[id=%s, userName='%s']",
                this.getId(), this.getUserName());
    }


}

