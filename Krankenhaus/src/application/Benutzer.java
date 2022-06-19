package application;

public class Benutzer {

	private String id;
	private String password;

	// Konstruktor
	public Benutzer(String id, String password) {
		this.id = id;
		this.password = password;
	}

	// Getter und Setter
	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
