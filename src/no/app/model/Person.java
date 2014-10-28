package no.app.model;

public class Person {
		
	private String username;
	private String password;
	
	public Person() {
		this("unkown", "uknown");
	}
	
	public Person(String username, String password) {
		setUsername(username);
		setPassword(password);
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Username: " + username + "\nPassword: " + password;
	}
}
