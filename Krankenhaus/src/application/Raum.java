package application;

public class Raum {
		
	//Attribute
	
	int anzahlBetten;
	int anzahlBelegteBetten;
	boolean quarant�ne;
	String raumtyp;
	int raumID;
	
	
	//Getter und Setter
	
	public int getAnzahlBetten() {
		return anzahlBetten;
	}
	public void setAnzahlBetten(int anzahlBetten) {
		this.anzahlBetten = anzahlBetten;
	}
	public int getAnzahlBelegteBetten() {
		return anzahlBelegteBetten;
	}
	public void setAnzahlBelegteBetten(int anzahlBelegteBetten) {
		this.anzahlBelegteBetten = anzahlBelegteBetten;
	}
	public boolean isQuarant�ne() {
		return quarant�ne;
	}
	public void setQuarant�ne(boolean quarant�ne) {
		this.quarant�ne = quarant�ne;
	}
	public String getRaumtyp() {
		return raumtyp;
	}
	public void setRaumtyp(String raumtyp) {
		this.raumtyp = raumtyp;
	}
	public int getRaumID() {
		return raumID;
	}
	public void setRaumID(int raumID) {
		this.raumID = raumID;
	}

}
