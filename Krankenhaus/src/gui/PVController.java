package gui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import application.Patient;
import application.ReaderWriter;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;

public class PVController {

	// Variablen um neue Scene zu erzeugen
	private Stage stage;
	private Scene scene;

	// Zugriff auf FXML Elemente
	@FXML
	Button btnHauptmenü;
	@FXML
	Button btnPatBearbeiten;
	@FXML
	Button btnPatDelete;
	@FXML
	ComboBox<String> cmbPatientenSort;

	@FXML
	ListView<ObservableList> lvPatDat01 = new ListView<ObservableList>(); // Initialisiert die ListView mit dem
																			// Parametertyp ObservableList

	@FXML
	public void initialize() {
		// Sortieren ComboBox Inhalte:
		cmbPatientenSort.getItems().removeAll(cmbPatientenSort.getItems());
		cmbPatientenSort.getItems().addAll("Sortieren nach", "ID-aufsteigend", "ID-absteigend", "Vorname-aufsteigend",
				"Vorname-absteigend", "Alter-aufsteigend", "Alter-absteigend");
		cmbPatientenSort.getSelectionModel().select("Sortieren nach");
	}

	// Methode um die Patientendaten aus der Text Datei in die TableView einzufügen
	@FXML
	public void zeigePatientenListe() throws IOException {

		String[] patients = ReaderWriter.readToArray("Patienten.txt"); // Lädt den Inhalt der übergebenen Text Datei
																		// durch die Methode readToArray der
																		// ReaderWriter Klasse in ein neues String Array

		ObservableList<String> pat = FXCollections.observableArrayList(patients);

		ObservableList<String> patBsp = FXCollections.observableArrayList();

		for (int i = 0; i < pat.size(); i++) {
			String[] patientendaten = patients[i].split(",");

			String id = patientendaten[0];
			String vorname = patientendaten[1];
			String nachname = patientendaten[2];
			String alter = patientendaten[3];
			String aufenthaltsgrund = patientendaten[4];
			patBsp.addAll(id, vorname, nachname, alter, aufenthaltsgrund);

			// Fehler -->Cannot invoke "javafx.scene.control.ListView.getItems()" because
			// "gui.PVController.lvPatDat01" is null
			// System.out.println(vorname);

			// Gibt die Daten der Text

			System.out.println(patients[i]);

			// System.out.println(Arrays.toString(patientendaten)); //gibt den inhalt der
			// txt datei wieder

			lvPatDat01.getItems().addAll(patBsp); // müsste eigentlich die patientendaten in die listview eintragen

			// lvPatDat01.notify(); //Notify() müsste die ListView updaten
			String temp = "";

			for (String item : patBsp) {
				// System.out.println(item);
				temp += item;
			}
		}
	}

	// Events
	@FXML
	public void goToHauptmenü(ActionEvent event) throws IOException // Diese Methode lädt den Hauptmenübildschirm in dem
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
		String[] patients = ReaderWriter.readToArray("Patienten.txt");
		ObservableList<String> pat = FXCollections.observableArrayList(patients);
		for (int i = 0; i < pat.size(); i++) {
			String[] patientendaten = patients[i].split(",");

			if (cmbPatientenSort.getValue().contains("ID-aufsteigend")) {
				// application.Sortieren.sortIDAscending(patientendaten[0]);
			} else if (cmbPatientenSort.getValue().contains("ID-absteigend")) {
				// application.Sortieren.sortIDDescending(patientendaten[0]);
			}else if (cmbPatientenSort.getValue().contains("Vorname-aufsteigend")) {
				// application.Sortieren.sortNameAscending(patientendaten[1]);
			}
			else if (cmbPatientenSort.getValue().contains("Vorname-absteigend")) {
				// application.Sortieren.sortNameDescending(patientendaten[1]);
			}
			else if (cmbPatientenSort.getValue().contains("Nachname-aufsteigend")) {
				// application.Sortieren.sortNameAscending(patientendaten[2]);
			}
			else if (cmbPatientenSort.getValue().contains("Nachname-absteigend")) {
				// application.Sortieren.sortNameDescending(patientendaten[2]);
			}
			else if (cmbPatientenSort.getValue().contains("Alter-aufsteigend")) {
				// application.Sortieren.sortIDDescending(patientendaten[3]);
			}			else if (cmbPatientenSort.getValue().contains("Alter-absteigend")) {
				// application.Sortieren.sortIDDescending(patientendaten[3]);
			}
			
		}

		{

		}
	}
}
