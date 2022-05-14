package application;

import java.io.File;
import java.util.Scanner;

public class PersonenVerwaltung {

	// Attribute

	String aufenthaltsgrund;

	static Scanner scanner;
	static File file = new File("D://Entwicklung//Java//Repository//KrankenhausVerwaltung//Krankenhaus//src//application//Arzt.txt");
	static String text;
	
	// Methoden

	public static void zeigePersonalListe() {

		try {
			scanner = new Scanner(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(scanner.hasNext()) {
			text += scanner.next();
		}
		System.out.println(text);
	}

	public static void zeigePatientenListe() {

	}

	public static void sucheID() {

	}

	public static void sucheName() {

	}

	public static void sucheVorname() {

	}

	public static void sucheTätigkeitsbereich() {

	}

	public static void sucheAufenthaltsgrund() {

	}

	public static void sortiereID() {

	}

	public static void sortiereName() {

	}

	public static void sortiereVorname() {

	}

	public static void sortiereTätigkeitsbereich() {

	}

	public static void sortiereBerufsbezeichnung() {

	}

	public static void erstellePatient() {

	}

	public static void bearbeitePatient() {

	}

	public static void löschePatient() {

	}
	
	
}
