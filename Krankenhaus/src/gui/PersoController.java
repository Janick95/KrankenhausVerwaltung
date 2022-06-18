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
	Button btnHauptmenü;	
	@FXML
	ListView<String> lvPflegerDat = new ListView<String>();
	@FXML
	ListView<String> lvAerzteDat = new ListView<String>();

	// Zugriff auf FXML Elemente des zweiten Personal-Bildschirms
	@FXML
	TextField txtPersoVorname;
	@FXML
	TextField txtPersoNachname;
	@FXML
	TextField txtPersoRang;
	@FXML
	TextField txtPersoSchule;
	@FXML
	TextField txtPersoAbteilung;
	@FXML
	ComboBox<String> cmbPersonalSort;
	@FXML
	Button btnPersoErstellen;
	@FXML
	Button btnLoeschPerso;
	@FXML
	public void initialize() throws IOException {
		//comboBoxValues();
		  zeigePersonalListe();
	}
	
	public void comboBoxValues() {
		// Sortieren ComboBox Inhalte:
		  cmbPersonalSort.getItems().removeAll(cmbPersonalSort.getItems());
		  cmbPersonalSort.getItems().addAll("Sortieren nach", "ID-aufsteigend",
		  "ID-absteigend", "Vorname-aufsteigend", "Vorname-absteigend",
		  "Alter-aufsteigend", "Alter-absteigend");
		  cmbPersonalSort.getSelectionModel().select("Sortieren nach");
	}

	@FXML
	public void zeigePersonalListe() throws IOException {
		String[] pfleger = ReaderWriter.readToArray("Pfleger.txt"); // Lädt den Inhalt der übergebenen Text Datei durch
		String[] aerzte = ReaderWriter.readToArray("Arzt.txt"); // die Methode readToArray der ReaderWriter Klasse
																// in ein neues String Array

		ObservableList<String> pflegerList = FXCollections.observableArrayList(pfleger);
		ObservableList<String> aerzteList = FXCollections.observableArrayList(aerzte);

		lvPflegerDat.setItems(pflegerList);
		lvAerzteDat.setItems(aerzteList);
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
	
	// Beim klick auf Button "Neues Personal erstellen" wird der zweite
	// Personalbildschirm geladen
	@FXML
	public void goToPersonalErstellen(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/gui/Personaldaten02.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Neues Personal erstellen");
		// stage.getIcons().add(new Image("/img/Logo_KrankenhausVerwaltung.png"));
		stage.show();
	}

	// Nach der Auswahl des gewünschten Sortierparameters wird der
		// Sortieralgorithmus auf das Element angewandt
		@FXML
		public String[] pickSort(ActionEvent event) throws IOException {
			String[] pfleger1 = ReaderWriter.readToArray("Pfleger.txt"); 
			String[] aerzte1 = ReaderWriter.readToArray("Arzt.txt");
			ObservableList<String> pflege1 = FXCollections.observableArrayList(pfleger1);
			ObservableList<String> arzt1 = FXCollections.observableArrayList(aerzte1);
			
			for (int i = 0; i < pflege1.size(); i++) {
				String[] pflegerdaten = pfleger1[i].split(",");
				String[] aerztedaten = aerzte1[i].split(",");

				if (cmbPersonalSort.getValue().contains("ID-aufsteigend")) {
					// application.Sortieren.sortIDAscending(pflegerdaten[0]);
					// return pflegerdaten;
				} else if (cmbPersonalSort.getValue().contains("ID-absteigend")) {
					// application.Sortieren.sortIDDescending(pflegerdaten[0]);
					// return pflegerdaten;
				} else if (cmbPersonalSort.getValue().contains("Vorname-aufsteigend")) {
					// application.Sortieren.sortNameAscending(pflegerdaten[1]);
					// return pflegerdaten;
				} else if (cmbPersonalSort.getValue().contains("Vorname-absteigend")) {
					// application.Sortieren.sortNameDescending(pflegerdaten[1]);
					// return pflegerdaten;
				} else if (cmbPersonalSort.getValue().contains("Nachname-aufsteigend")) {
					// application.Sortieren.sortNameAscending(pflegerdaten[2]);
					// return pflegerdaten;
				} else if (cmbPersonalSort.getValue().contains("Nachname-absteigend")) {
					// application.Sortieren.sortNameDescending(pflegerdaten[2]);
					// return pflegerdaten;
				} else if (cmbPersonalSort.getValue().contains("Alter-aufsteigend")) {
					// application.Sortieren.sortAgeAscending(pflegerdaten[3]);
					// return pflegerdaten;
				} else if (cmbPersonalSort.getValue().contains("Alter-absteigend")) {
					// application.Sortieren.sortAgeDescending(pflegerdaten[3]);
					// return pflegerdaten;
				}

			}
			return pfleger1;
		}
	
	
	// Methode um neues Personal zu erstellen
	@FXML
	public void personalErstellen(ActionEvent event) throws IOException {
		if (txtPersoRang.getText().equals("Arzt")) {
			String[] arzt = new String[6];
			int lower = 1000;
			int upper = 1999;
			String id = String.valueOf((int) (Math.random() * (upper - lower))) + lower;

			String vorname = txtPersoVorname.getText();
			String nachname = txtPersoNachname.getText();
			String rang = txtPersoRang.getText();
			String schule = txtPersoSchule.getText();
			String abteilung = txtPersoAbteilung.getText();

			arzt[0] = id;
			arzt[1] = vorname;
			arzt[2] = nachname;
			arzt[3] = rang;
			arzt[4] = schule;
			arzt[5] = abteilung;
			for (int i = 0; i < arzt.length; i++) {
				arzt[i].trim();
				arzt[i].toString().split(",");

			}				
			Alert mesg = new Alert(AlertType.CONFIRMATION);
			mesg.setContentText("Arzt hinzugefügt");
			mesg.showAndWait();
			application.ReaderWriter.writeStringIntoTxt(Arrays.toString(arzt).split(","), "Arzt.txt");
		} else if (txtPersoRang.getText().equals("Pfleger")) {
			String[] pfleger = new String[6];
			int lower = 2000;
			int upper = 2999;

			String id = String.valueOf((int) (Math.random() * (upper - lower) + lower));
			String vorname = txtPersoVorname.getText();
			String nachname = txtPersoNachname.getText();
			String rang = txtPersoRang.getText();
			String schule = txtPersoSchule.getText();
			String abteilung = txtPersoAbteilung.getText();

			pfleger[0] = id;
			pfleger[1] = vorname;
			pfleger[2] = nachname;
			pfleger[3] = rang;
			pfleger[4] = schule;
			pfleger[5] = abteilung;

			for (int i = 0; i < pfleger.length; i++) {
				pfleger[i].trim();
				pfleger[i].toString().split(",");
			}
			application.ReaderWriter.writeStringIntoTxt(Arrays.toString(pfleger), "Pfleger.txt");

			Alert mesg = new Alert(AlertType.CONFIRMATION);
			mesg.setContentText("Pfleger hinzugefügt");
			mesg.showAndWait();
		}
	}
	@FXML
	public void loeschePerso(ActionEvent event) throws IOException {
		//deletePat = lvPatDat01.getSelectionModel().getSelectedItem();
		//application.ReaderWriter.deleteFromTxt(deletePat.toString(), "Patienten.txt"); lvPflegerDat lvAerzteDat
		String deletePfleger = lvPflegerDat.getSelectionModel().getSelectedItem();
		System.out.println(deletePfleger);
		
		application.ReaderWriter.deleteFromTxt(deletePfleger, "Pfleger.txt");
	}

}
