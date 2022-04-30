package application;

import java.util.Date;

public class Termin {

	// Attribute

	int terminID;
	Date datum;
	int raumID;
	int arztID;
	int patientID;

	// Getter und Setter
	public int getTerminID() {
		return terminID;
	}

	public void setTerminID(int terminID) {
		this.terminID = terminID;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public int getRaumID() {
		return raumID;
	}

	public void setRaumID(int raumID) {
		this.raumID = raumID;
	}

	public int getArztID() {
		return arztID;
	}

	public void setArztID(int arztID) {
		this.arztID = arztID;
	}

	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
}
