package gui;

import java.io.IOException;
import java.util.Arrays;

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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class PersoController {

	// Variablen um neue Scene zu erzeugen
	private Stage stage;
	private Scene scene;

	// PersonalBildschirm
	@FXML
	Button btnMainmenu;
	@FXML
	TextField txtSearchStaff;
	@FXML
	ListView<String> lvNurseDat = new ListView<String>();
	@FXML
	ListView<String> lvDocDat = new ListView<String>();

	@FXML
	ComboBox<String> cmbStaffSort;
	@FXML
	Button btnCreateStaff;
	@FXML
	Button btnDeleteStaff;

	@FXML
	public void initialize() throws IOException {
		/// Sortieren ComboBox Inhalte:
		cmbStaffSort.getItems().removeAll(cmbStaffSort.getItems());
		cmbStaffSort.getItems().addAll("Sortieren nach", "ID-aufsteigend", "ID-absteigend", "Name-aufsteigend",
				"Name-absteigend", "Spezialität-aufsteigend", "Spezialität-absteigend");
		cmbStaffSort.getSelectionModel().select("Sortieren nach");
		String[] nurse = ReaderWriter.readToArray("Pfleger.txt"); // Lädt den Inhalt der übergebenen Text Datei durch
		String[] doctor = ReaderWriter.readToArray("Arzt.txt");
		showStaffList(nurse, doctor);
	}

	@FXML
	public void showStaffList(String[] nurse, String[] doctor) throws IOException {

		ObservableList<String> nurseList = FXCollections.observableArrayList(nurse);
		ObservableList<String> doctorList = FXCollections.observableArrayList(doctor);

		lvNurseDat.setItems(nurseList);
		lvDocDat.setItems(doctorList);
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

	// Nach der Auswahl des gewünschten Sortierparameters wird der
	// Sortieralgorithmus auf das Element angewandt
	@FXML
	public void pickSort(ActionEvent event) throws IOException {
		String[] nurse1 = ReaderWriter.readToArray("Pfleger.txt");
		String[] doctor1 = ReaderWriter.readToArray("Arzt.txt");
		ObservableList<String> nurses1 = FXCollections.observableArrayList(nurse1);
		ObservableList<String> docs1 = FXCollections.observableArrayList(doctor1);
		lvNurseDat.getItems();
		lvDocDat.getItems();
		if (cmbStaffSort.getValue().contains("ID-aufsteigend")) {
			String[] sortedIDN = application.Sortieren.sortIDAscending(nurse1);
			String[] sortedIDD = application.Sortieren.sortIDAscending(doctor1);
			nurses1 = FXCollections.observableArrayList(sortedIDN);
			docs1 = FXCollections.observableArrayList(sortedIDD);
			lvNurseDat.setItems(nurses1);
			lvDocDat.setItems(docs1);

		} else if (cmbStaffSort.getValue().contains("ID-absteigend")) {
			String[] sortedIDN = application.Sortieren.sortIDDescending(nurse1);
			String[] sortedIDD = application.Sortieren.sortIDDescending(doctor1);
			nurses1 = FXCollections.observableArrayList(sortedIDN);
			docs1 = FXCollections.observableArrayList(sortedIDD);
			lvNurseDat.setItems(nurses1);
			lvDocDat.setItems(docs1);
		} else if (cmbStaffSort.getValue().contains("Name-aufsteigend")) {
			String[] sortedNameN = application.Sortieren.sortNameAscending(nurse1);
			String[] sortedNameD = application.Sortieren.sortNameAscending(doctor1);
			nurses1 = FXCollections.observableArrayList(sortedNameN);
			docs1 = FXCollections.observableArrayList(sortedNameD);
			lvNurseDat.setItems(nurses1);
			lvDocDat.setItems(docs1);
		} else if (cmbStaffSort.getValue().contains("Name-absteigend")) {
			String[] sortedNameN = application.Sortieren.sortNameDescending(nurse1);
			String[] sortedNameD = application.Sortieren.sortNameDescending(doctor1);
			nurses1 = FXCollections.observableArrayList(sortedNameN);
			docs1 = FXCollections.observableArrayList(sortedNameD);
			lvNurseDat.setItems(nurses1);
			lvDocDat.setItems(docs1);

		} else if (cmbStaffSort.getValue().contains("Spezialität-aufsteigend"))// Nur für Ärzte
		{
			String[] sortedSpecial = application.Sortieren.sortSpecialFieldAscending(doctor1);
			docs1 = FXCollections.observableArrayList(sortedSpecial);
			lvDocDat.setItems(docs1);
		} else if (cmbStaffSort.getValue().contains("Spezialität-absteigend")) {
			String[] sortedSpecial = application.Sortieren.sortSpecialFieldDescending(doctor1);
			docs1 = FXCollections.observableArrayList(sortedSpecial);
			lvDocDat.setItems(docs1);
		}

	}

	// Beim klick auf Button "Neues Personal erstellen" wird der zweite
	// Personalbildschirm geladen
	@FXML
	public void goToStaffCreator(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/gui/Personaldaten02.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Neuen Patienten erstellen");
		// stage.getIcons().add(new Image("/img/Logo_KrankenhausVerwaltung.png"));
		stage.show();
	}

	@FXML
	public void loeschePerso(ActionEvent event) throws IOException {
		int NurseIndex = lvNurseDat.getSelectionModel().getSelectedIndex();
		String[] nurses = ReaderWriter.readToArray("Pfleger.txt");
		String[] doctors = ReaderWriter.readToArray("Arzt.txt");
		if (lvNurseDat.getSelectionModel().isSelected(NurseIndex)) {
			// Lösche Pfleger
			String deleteNurse = lvNurseDat.getSelectionModel().getSelectedItem();
			String[] nurseDelete = deleteNurse.split(",");

			System.out.println(deleteNurse);
			application.ReaderWriter.deleteFromTxt(nurseDelete[0], "Pfleger.txt");

			showStaffList(nurses, doctors);
		} else {
			int DoctorIndex = lvDocDat.getSelectionModel().getSelectedIndex();
			if (lvDocDat.getSelectionModel().isSelected(DoctorIndex)) {
				// Lösche Arzt
				String deleteDoctor = lvDocDat.getSelectionModel().getSelectedItem();
				String[] docDelete = deleteDoctor.split(",");

				System.out.println(deleteDoctor);
				application.ReaderWriter.deleteFromTxt(docDelete[0], "Arzt.txt");

				showStaffList(nurses, doctors);
			}
		}
	}

}
