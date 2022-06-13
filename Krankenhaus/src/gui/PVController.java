package gui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import application.Patient;
import application.ReaderWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class PVController {

	// Variablen um neue Scene zu erzeugen
	private Stage stage;
	private Scene scene;

	// Zugriff auf FXML Elemente
	@FXML
	Button btnHauptmenü;

	@FXML
	static
	TableView tblPatient01;
	@FXML
	static
	TableColumn colId01;
	@FXML
	static
	TableColumn colVorname01;

	@FXML
	static
	TableColumn colNachname01;

	@FXML
	static
	TableColumn colAufenthalt01;

	@FXML
	static
	TableColumn colRaum01;
	@FXML
	static
	TableColumn colOpDat01;

	// Methode um die Patientendaten aus der Text Datei in die TableView einzufügen
	@FXML
	public static void zeigePatientenListe() throws IOException {

		String[] patient = ReaderWriter.readToArray("Patienten.txt");
		/*String[] raum = ReaderWriter.readToArray("Räume.txt");
		String[] opDat = ReaderWriter.readToArray("Termine.txt");*/
		String lines1 = Arrays.toString(patient);
		/*
		 *String lines2 = Arrays.toString(raum);
		 *String lines3 = Arrays.toString(opDat); 
		 */
		
		for (int i = 0; i < patient.length; i++) {
			try {
				String [] lineToken = lines1.split(",");
				
				
				/*Patient pat = new Patient();
				
				pat.setVorname(lineToken[0].trim());
				pat.setName(lineToken[1].trim());
				pat.setAufenthaltsgrund(lineToken[2].trim());
				pat.setVorname(lineToken[0].trim());
				pat.setVorname(lineToken[0].trim());
				pat.setVorname(lineToken[0].trim());*/
				
				
				String prefix = lineToken[0].trim();
				String vorname = lineToken[1].trim();
				String nachname = lineToken[2].trim();
				String famstatus = lineToken[3].trim();
				String doktor = lineToken[4].trim();
				String aufgru = lineToken[5].trim();
				
	/*			System.out.println(prefix);
				System.out.println(vorname);
				System.out.println(nachname);
				System.out.println(famstatus);
				System.out.println(doktor);
				System.out.println(aufgru);
	*/
					
			}
			finally {
				
			}
		}


	}

	// Events
	@FXML
	public void goToHauptmenü(ActionEvent event) throws IOException // This method loads a new scene in a current window
	{
		Parent root = FXMLLoader.load(getClass().getResource("/gui/HauptmenuScreen02.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
