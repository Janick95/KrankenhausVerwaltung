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
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class RVController {

	// Variablen um neue Scene zu erzeugen
	private Stage stage;
	private Scene scene;

	// Zugriff auf FXML Elemente
	@FXML
	Button btnHauptmenü;
	
	@FXML
	Button btnErstelleRaum;
	
	@FXML
	Button btnLoescheRaum;

	@FXML
	ListView<String> lvRaum = new ListView<String>();
	@FXML
	ComboBox<String> cmbRaumSort;
	@FXML
	TextField txtBetten;
	@FXML
	TextField txtPatAnz;
	
	
	@FXML
	public void initialize() throws IOException {
		zeigeRaumListAn();
	}

	// Methode um die roomientendaten aus der Text Datei in die TableView einzufügen
	@FXML
	public void tempMethode(ActionEvent event) {
		try {
			zeigeRaumListAn();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	public void zeigeRaumListAn() throws IOException {

		String[] rooms = ReaderWriter.readToArray("Räume.txt");
		ObservableList<String> roomList = FXCollections.observableArrayList(rooms);
		lvRaum.setItems(roomList);
		
		
		}
	// Events
	@FXML
	public void goToHauptmenue(ActionEvent event) throws IOException // This method loads a new scene in a current window
	{
		Parent root = FXMLLoader.load(getClass().getResource("/gui/HauptmenuScreen02.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	public void erstelleRaum(ActionEvent event) throws IOException {
		String[] raum = new String[3];
		int lower = 4000;
		int upper = 4999;

		String id = String.valueOf((int) (Math.random() * (upper - lower) + lower));
		String betten = txtBetten.getText();
		String patAnz = txtPatAnz.getText();

		raum[0] = id;
		raum[1] = betten;
		raum[2] = patAnz;

		for (int i = 0; i < raum.length; i++) {
			raum[i].trim();
			raum[i].toString().split(",");
		}
		Alert mesg = new Alert(AlertType.CONFIRMATION);
		mesg.setContentText("Raum hinzugefügt");
		mesg.showAndWait();
		application.ReaderWriter.writeStringIntoTxt(Arrays.toString(raum), "Räume.txt");
	}
	@FXML
	public void loescheRaum(ActionEvent event) throws IOException {
		String[] raeume = ReaderWriter.readToArray("Räume.txt");
		ObservableList<String> deleteRaum;
		//deleteRaum = lvRaum.getSelectionModel().getSelectedItem();
		//application.ReaderWriter.deleteFromTxt(deleteRaum.toString(), "Patienten.txt");
	}
}
