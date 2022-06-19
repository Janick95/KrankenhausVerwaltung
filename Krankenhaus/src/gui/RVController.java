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
	TextField txtSearchRoom;
	@FXML
	ListView<String> lvRooms = new ListView<String>();
	@FXML
	ComboBox<String> cmbRoomSort;
	@FXML
	TextField txtBetten;
	@FXML
	TextField txtPatAnz;
	
	
	@FXML
	public void initialize() throws IOException {
		// Sortieren ComboBox Inhalte:
		cmbRoomSort.getItems().removeAll(cmbRoomSort.getItems());
		cmbRoomSort.getItems().addAll("Sortieren nach", "ID-aufsteigend", "ID-absteigend");
		cmbRoomSort.getSelectionModel().select("Sortieren nach");
		String[] rooms = ReaderWriter.readToArray("Räume.txt");
		showRoomList(rooms);
	}

	// Methode um die roomientendaten aus der Text Datei in die TableView einzufügen
	@FXML
	public void showRoomList(String[] rooms) throws IOException {

		ObservableList<String> roomList = FXCollections.observableArrayList(rooms);
		lvRooms.setItems(roomList);
		
		
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
		String[] rooms1 = ReaderWriter.readToArray("Räume.txt");
		ObservableList<String> rom = FXCollections.observableArrayList(rooms1);
		String[] room = new String[3];
		int lower = 4000;
		int upper = 4999;

		String id = String.valueOf((int) (Math.random() * (upper - lower) + lower));
		String beds = txtBetten.getText();
		String patNum = txtPatAnz.getText();

		room[0] = id;
		room[1] = beds;
		room[2] = patNum;

		String newRoom = id+","+beds+","+patNum;
		
		
		
		for (int i = 0; i < room.length; i++) {
			room[i].trim();
		}
		Alert mesg = new Alert(AlertType.CONFIRMATION);
		mesg.setContentText("Raum hinzugefügt");
		mesg.showAndWait();
		application.ReaderWriter.writeStringIntoTxt(newRoom, "Räume.txt");
	}
	// Nach der Auswahl des gewünschten Sortierparameters wird der
		// Sortieralgorithmus auf das Element angewandt
		@FXML
		public void pickSort(ActionEvent event) throws IOException {
			String[] rooms1 = ReaderWriter.readToArray("Räume.txt");
			ObservableList<String> rom = FXCollections.observableArrayList(rooms1);
			lvRooms.getItems();
				if (cmbRoomSort.getValue().contains("ID-aufsteigend")) {
					String[] sortedID = application.Sortieren.sortIDAscending(rooms1);
					rom = FXCollections.observableArrayList(sortedID);
					lvRooms.setItems(rom);
				} else if (cmbRoomSort.getValue().contains("ID-absteigend")) {
					String[] sortedID = application.Sortieren.sortIDDescending(rooms1);
					rom = FXCollections.observableArrayList(sortedID);
					lvRooms.setItems(rom);
				} 
			}

	
	
	
	@FXML
	public void loescheRaum(ActionEvent event) throws IOException {
		String deleteRoom = lvRooms.getSelectionModel().getSelectedItem();
		String[] roomDelete = deleteRoom.split(",");
	
		System.out.println(deleteRoom);
		application.ReaderWriter.deleteFromTxt(roomDelete[0], "Räume.txt");
		
		String[] rooms = ReaderWriter.readToArray("Räume.txt");
		showRoomList(rooms);
	}
}
