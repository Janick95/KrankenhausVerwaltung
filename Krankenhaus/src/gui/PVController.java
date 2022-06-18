package gui;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import application.Patient;
import application.Pfleger;
import application.ReaderWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class PVController {

	// Variablen um neue Scene zu erzeugen
	private Stage stage;
	private Scene scene;

	// Zugriff auf FXML Elemente des ersten Patienten-Bildschirms
	@FXML
	Button btnHauptmenü;
	@FXML
	Button btnPatErstellen;
	@FXML
	Button btnPatDelete;
	@FXML
	ComboBox<String> cmbPatientenSort;
	@FXML
	ListView<String> lvPatDat01 = new ListView<String>(); // Initialisiert die ListView mit dem
																			// Parametertyp ObservableList

	// Zugriff auf FXML Element des zweiten Patienten-Bildschirms
	@FXML
	Button btnHauptmenü02;
	@FXML
	TextField txtVorname02;
	@FXML
	TextField txtNachname02;
	@FXML
	TextField txtAlter02;
	@FXML
	TextField txtFamstat02;
	@FXML
	TextField txtAufenthalt02;
	@FXML
	TextField txtDoktor02;
	@FXML
	Button btnErstellen02;


	@FXML
	public void initialize() throws IOException {
		/*// Sortieren ComboBox Inhalte:
			cmbPatientenSort.getItems().removeAll(cmbPatientenSort.getItems());
		cmbPatientenSort.getItems().addAll("Sortieren nach", "ID-aufsteigend", "ID-absteigend", "Vorname-aufsteigend",
				"Vorname-absteigend", "Alter-aufsteigend", "Alter-absteigend");
		cmbPatientenSort.getSelectionModel().select("Sortieren nach");*/
		zeigePatientenListe();
	}

	// Methode um die Patientendaten aus der Text Datei in die ListView einzufügen
	@FXML
	public void zeigePatientenListe() throws IOException {

		String[] patients = ReaderWriter.readToArray("Patienten.txt"); // Lädt den Inhalt der übergebenen Text Datei
																		// durch die Methode readToArray der
																		// ReaderWriter Klasse in ein neues String Array
		
		ObservableList<String> patBsp = FXCollections.observableArrayList(patients);
		lvPatDat01.setItems(patBsp);
	}
	




	
	// Events
		@FXML
		public void goToHauptmenue(ActionEvent event) throws IOException // Diese Methode lädt den Hauptmenübildschirm in dem
																		// aktuellen Fenster
		{
			Parent root = FXMLLoader.load(getClass().getResource("/gui/HauptmenuScreen02.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}


	// Nach der Auswahl des gewünschten Sortierparameters wird der
	// Sortieralgorithmus auf das Element angewandt
	@FXML
	public String[] pickSort(ActionEvent event) throws IOException {
		String[] patients1 = ReaderWriter.readToArray("Patienten.txt");
		ObservableList<String> pat = FXCollections.observableArrayList(patients1);
		for (int i = 0; i < pat.size(); i++) {
			String[] patientendaten = patients1[i].split(",");

			if (cmbPatientenSort.getValue().contains("ID-aufsteigend")) {
				// application.Sortieren.sortIDAscending(patientendaten[0]);
				// return patientendaten;
			} else if (cmbPatientenSort.getValue().contains("ID-absteigend")) {
				// application.Sortieren.sortIDDescending(patientendaten[0]);
				// return patientendaten;
			} else if (cmbPatientenSort.getValue().contains("Vorname-aufsteigend")) {
				// application.Sortieren.sortNameAscending(patientendaten[1]);
				// return patientendaten;
			} else if (cmbPatientenSort.getValue().contains("Vorname-absteigend")) {
				// application.Sortieren.sortNameDescending(patientendaten[1]);
				// return patientendaten;
			} else if (cmbPatientenSort.getValue().contains("Nachname-aufsteigend")) {
				// application.Sortieren.sortNameAscending(patientendaten[2]);
				// return patientendaten;
			} else if (cmbPatientenSort.getValue().contains("Nachname-absteigend")) {
				// application.Sortieren.sortNameDescending(patientendaten[2]);
				// return patientendaten;
			} else if (cmbPatientenSort.getValue().contains("Alter-aufsteigend")) {
				// application.Sortieren.sortAgeAscending(patientendaten[3]);
				// return patientendaten;
			} else if (cmbPatientenSort.getValue().contains("Alter-absteigend")) {
				// application.Sortieren.sortAgeDescending(patientendaten[3]);
				// return patientendaten;
			}

		}
		return patients1;
	}

	// Beim klick auf Button "Neuen Patienten erstellen" wird der zweite
	// Patientenbildschirm geladen
	@FXML
	public void patientenlErstellen(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/gui/Patientendaten02.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Neuen Patienten erstellen");
		// stage.getIcons().add(new Image("/img/Logo_KrankenhausVerwaltung.png"));
		stage.show();
	}

	@FXML
	public void goToPatListe(ActionEvent event) throws IOException {
		String[] patient2 = new String[7];
		int lower = 3000;
		int upper = 3999;

		String id = String.valueOf((int) (Math.random() * (upper - lower)));
		String vorname = txtVorname02.getText();
		String nachname = txtNachname02.getText();
		String alter = txtAlter02.getText();
		String grund = txtAufenthalt02.getText();
		String famstat = txtFamstat02.getText();
		String arzt = txtDoktor02.getText();
		
		patient2 [0] = id;
		patient2 [1] = vorname;
		patient2 [2] = nachname;
		patient2 [3] = alter;
		patient2 [4] = grund;
		patient2 [5] = famstat;
		patient2 [6] = arzt;
		
		application.ReaderWriter.writeStringIntoTxt(Arrays.toString(patient2).split(","), "Arzt.txt");

		Parent root = FXMLLoader.load(getClass().getResource("/gui/Patientendaten01.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Neuen Patienten erstellen");
		// stage.getIcons().add(new Image("/img/Logo_KrankenhausVerwaltung.png"));
		stage.show();
	}

	@FXML
	public void loeschePat(ActionEvent event) throws IOException {
		String[] patients = ReaderWriter.readToArray("Patienten.txt");
		ObservableList<String> deletePat;
		//deletePat = lvPatDat01.getSelectionModel().getSelectedItem();
		//application.ReaderWriter.deleteFromTxt(deletePat.toString(), "Patienten.txt");
	}

}