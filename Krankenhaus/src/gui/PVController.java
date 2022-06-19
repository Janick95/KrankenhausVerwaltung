package gui;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import application.Patient;
import application.Pfleger;
import application.ReaderWriter;
import application.Sortieren;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class PVController {

	// Variablen um neue Scene zu erzeugen
	private Stage stage;
	private Scene scene;

	// Zugriff auf FXML Elemente des ersten Patienten-Bildschirms
	@FXML
	Button btnMainmenu;
	@FXML
	Button btnCreatePat;
	@FXML
	Button btnPatDelete;
	@FXML
	Button btnSearch;
	@FXML
	TextField txtSearchPatient;
	@FXML
	ComboBox<String> cmbPatientSearch;
	@FXML
	ComboBox<String> cmbPatientSort;
	@FXML
	ListView<String> lvPatDat01 = new ListView<String>(); // Initialisiert die ListView mit dem Parametertyp String

	@FXML
	public void initialize() throws IOException {

		// Sortieren ComboBox Inhalte:
		cmbPatientSort.getItems().removeAll(cmbPatientSort.getItems());
		cmbPatientSort.getItems().addAll("Sortieren nach", "ID-aufsteigend", "ID-absteigend", "Name-aufsteigend",
				"Name-absteigend", "Alter-aufsteigend", "Alter-absteigend", "Aufenthaltsgrund-aufsteigend",
				"Aufenthaltsgrund-absteigend");
		cmbPatientSort.getSelectionModel().select("Sortieren nach");
		
		// Suchen ComboBox Inhalte:
		cmbPatientSearch.getItems().removeAll(cmbPatientSort.getItems());
		cmbPatientSearch.getItems().addAll("Suchen nach", "ID", "Vorname", "Nachname", "Aufenthaltsgrund");
		cmbPatientSearch.getSelectionModel().select("Suchen nach");
		String[] patients = ReaderWriter.readToArray("Patienten.txt");
		showPatientList(patients);

	}

	// Methode um die Patientendaten aus der Text Datei in die ListView einzufügen
	@FXML
	public void showPatientList(String[] patients) throws IOException {

		// Lädt den Inhalt der übergebenen Text Datei
		// durch die Methode readToArray der
		// ReaderWriter Klasse in ein neues String Array

		ObservableList<String> patBsp = FXCollections.observableArrayList(patients);
		lvPatDat01.setItems(patBsp);
	}

	// Events
	@FXML
	public void goToMainmenu(ActionEvent event) throws IOException // Diese Methode lädt den Hauptmenübildschirm in dem
																	// aktuellen Fenster
	{
		Parent root = FXMLLoader.load(getClass().getResource("/gui/HauptmenuScreen02.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	
	@FXML
	public void patientSearch(ActionEvent evt)throws IOException {
		pickSearch();
	}

	// Nach der Auswahl des gewünschten Sortierparameters wird der
		// Sortieralgorithmus auf das Element angewandt
		@FXML
		public void pickSearch() throws IOException {
			String[] patients1 = ReaderWriter.readToArray("Patienten.txt");
			ObservableList<String> pat = FXCollections.observableArrayList(patients1);
			String search = txtSearchPatient.getText();
			if (cmbPatientSearch.getValue().contains("ID")) {
				String[] sortedPatients1 = Sortieren.sortIDAscending(patients1);
				String searchID = application.Suchen.searchID(search, sortedPatients1);
				pat = FXCollections.observableArrayList(searchID);
				lvPatDat01.setItems(pat);
			} else if (cmbPatientSearch.getValue().contains("Vorname")) {
				String[] searchSurname = application.Suchen.searchFirstName(search, patients1);
				pat = FXCollections.observableArrayList(searchSurname);
				lvPatDat01.setItems(pat);
			} else if (cmbPatientSearch.getValue().contains("Nachname")) {
				String[] searchName = application.Suchen.searchLastName(search, patients1);
				pat = FXCollections.observableArrayList(searchName);
				lvPatDat01.setItems(pat);
			} else if (cmbPatientSearch.getValue().contains("Aufenthaltsgrund")) {
				String[] searchReason = application.Suchen.searchReasonForStay(search, patients1);
				pat = FXCollections.observableArrayList(searchReason);
				lvPatDat01.setItems(pat);
			}

		}
	
	
	// Nach der Auswahl des gewünschten Sortierparameters wird der
	// Sortieralgorithmus auf das Element angewandt
	@FXML
	public void pickSort(ActionEvent event) throws IOException {
		String[] patients1 = ReaderWriter.readToArray("Patienten.txt");
		ObservableList<String> pat = FXCollections.observableArrayList(patients1);
		lvPatDat01.getItems();
		if (cmbPatientSort.getValue().contains("ID-aufsteigend")) {
			String[] sortedID = application.Sortieren.sortIDAscending(patients1);
			pat = FXCollections.observableArrayList(sortedID);
			lvPatDat01.setItems(pat);

		} else if (cmbPatientSort.getValue().contains("ID-absteigend")) {
			String[] sortedID = application.Sortieren.sortIDDescending(patients1);
			pat = FXCollections.observableArrayList(sortedID);
			lvPatDat01.setItems(pat);
		} else if (cmbPatientSort.getValue().contains("Name-aufsteigend")) {
			String[] sortedName = application.Sortieren.sortNameAscending(patients1);
			pat = FXCollections.observableArrayList(sortedName);
			lvPatDat01.setItems(pat);
		} else if (cmbPatientSort.getValue().contains("Name-absteigend")) {
			String[] sortedName = application.Sortieren.sortNameAscending(patients1);
			pat = FXCollections.observableArrayList(sortedName);
			lvPatDat01.setItems(pat);
		} else if (cmbPatientSort.getValue().contains("Alter-aufsteigend")) {
			String[] sortedID = application.Sortieren.sortIDAscending(patients1);
			pat = FXCollections.observableArrayList(sortedID);
			lvPatDat01.setItems(pat);
		} else if (cmbPatientSort.getValue().contains("Alter-absteigend")) {
			String[] sortedAge = application.Sortieren.sortAgeAscending(patients1);
			pat = FXCollections.observableArrayList(sortedAge);
			lvPatDat01.setItems(pat);
		} else if (cmbPatientSort.getValue().contains("Aufenthaltsreason-aufsteigend")) {
			String[] sortedAge = application.Sortieren.sortAgeAscending(patients1);
			pat = FXCollections.observableArrayList(sortedAge);
			lvPatDat01.setItems(pat);
		} else if (cmbPatientSort.getValue().contains("Aufenthaltsgrund-absteigend")) {
			String[] sortedReason = application.Sortieren.sortIDAscending(patients1);
			pat = FXCollections.observableArrayList(sortedReason);
			lvPatDat01.setItems(pat);
		}

	}

	// Beim klick auf Button "Neuen Patienten erstellen" wird der zweite
	// Patientenbildschirm geladen
	@FXML
	public void patientCreator(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/gui/Patientendaten02.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Neuen Patienten erstellen");
		// stage.getIcons().add(new Image("/img/Logo_KrankenhausVerwaltung.png"));
		stage.show();
	}

	@FXML
	public void deletePat(ActionEvent event) throws IOException {

		String deletePat = lvPatDat01.getSelectionModel().getSelectedItem();
		String[] patDelete = deletePat.split(",");

		System.out.println(deletePat);
		application.ReaderWriter.deleteFromTxt(patDelete[0], "Patienten.txt");

		String[] patients = ReaderWriter.readToArray("Patienten.txt");
		showPatientList(patients);

	}

}