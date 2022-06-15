package application;

public class Patient extends Person {

	// Attribute

	String aufenthaltsgrund;

	// Getter und Setter

	public String getAufenthaltsgrund() {
		return aufenthaltsgrund;
	}

	public void setAufenthaltsgrund(String aufenthaltsgrund) {
		this.aufenthaltsgrund = aufenthaltsgrund;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public int getAlter() {
		return alter;
	}

	public void setAlter(int alter) {
		this.alter = alter;
	}

	public String getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
