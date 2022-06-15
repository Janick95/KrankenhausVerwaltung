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

	/*@FXML
	ComboBox cmbPatientenSort;*/

	@FXML
	ListView<ObservableList> lvPatDat01 = new ListView<ObservableList>();
	

	// Methode um die Patientendaten aus der Text Datei in die TableView einzufügen
	@FXML
	public void tempMethode(ActionEvent event) {
		try {
			zeigePatientenListe();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	public void zeigePatientenListe() throws IOException {

		String[] patients = ReaderWriter.readToArray("Patienten.txt");

		ObservableList<String> pat = FXCollections.observableArrayList(patients);
		
		ObservableList<String> patBsp = FXCollections.observableArrayList();
		
		for (int i = 0; i < pat.size(); i++) {
			
		
			String[] patientendaten = patients[i].split(",");
			
			
			String id = patientendaten[0];
			String vorname = patientendaten[1];
			String nachname = patientendaten[2];
			String aufenthaltsgrund = patientendaten[3];
			String arzt = patientendaten[4];
			patBsp.addAll(id, vorname, nachname, aufenthaltsgrund, arzt);
			 // Fehler -->Cannot invoke "javafx.scene.control.ListView.getItems()" because "gui.PVController.lvPatDat01" is null
			//System.out.println(vorname);
			
			
			//Gibt die Daten der Text
			
			System.out.println(patients[i]);
			//System.out.println(Arrays.toString(patientendaten)); //gibt den inhalt der txt datei wieder
			lvPatDat01.getItems().addAll(patBsp); //müsste eigentlich die patientendaten in die listview eintragen
			
			}
		
		lvPatDat01.getItems().addAll(patBsp);
		//lvPatDat01.setCellFactory((Callback<ListView<ObservableList>, ListCell<ObservableList>>) patBsp);
		lvPatDat01.getItems();
		String temp = "";
		
		
		
		for(String item: patBsp) {
			//System.out.println(item);
			temp+=item;
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
