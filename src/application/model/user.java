package application.model;

public class user implements Comparable<user>{

	private String username;
	private String password;
	private String name;
	
	public user(String username, String password, String name) {
		this.username = username;
		this.password = password;
		this.name = name;
	}
	
	public user(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int compareTo(user o) {
		return username.compareTo(o.getUsername());
	}
	
	public boolean validate (String username, String password) {
		return this.username.equals(username) && this.password.equals(password);
	}

}
