package gui;

import java.io.IOException;
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
	ComboBox<String> cmbRoomSearch;
	@FXML
	Button btnRoomSearch;
	@FXML
	ComboBox<String> cmbRoomSort;
	@FXML
	TextField txtBetten;
	@FXML
	TextField txtPatAnz;

	@FXML
	public void initialize() throws IOException {
		// Suchen ComboBox Inhalte:
		cmbRoomSearch.getItems().removeAll(cmbRoomSearch.getItems());
		cmbRoomSearch.getItems().addAll("Suchen nach", "ID", "Freie-Betten");
		cmbRoomSearch.getSelectionModel().select("Suchen nach");

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
	public void goToHauptmenue(ActionEvent event) throws IOException // This method loads a new scene in a current
																		// window
	{
		if (LoginController.isAdmin == true) {
			Parent root = FXMLLoader.load(getClass().getResource("/gui/HauptmenuScreen02.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} else {
			Parent root = FXMLLoader.load(getClass().getResource("/gui/HauptmenuScreen01.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}

	@FXML
	public void roomSearch(ActionEvent evt) throws IOException {
		pickSearch();
	}

	// Nach der Auswahl des gewünschten Suchparameters wird der
	// Suchalgorithmus auf das Element angewandt
	@FXML
	public void pickSearch() throws IOException {
		String[] rooms1 = ReaderWriter.readToArray("Räume.txt");
		ObservableList<String> pat = FXCollections.observableArrayList(rooms1);
		String search = txtSearchRoom.getText();
		if (cmbRoomSearch.getValue().contains("ID")) {
			String[] sortedRoomID1 = Sortieren.sortIDAscending(rooms1);
			String searchID = application.Suchen.searchID(search, sortedRoomID1);
			pat = FXCollections.observableArrayList(searchID);
			lvRooms.setItems(pat);
		} else if (cmbRoomSearch.getValue().contains("Freie-Betten")) {
			String[] searchEmptyRooms = application.Suchen.searchFreeRooms(rooms1);
			pat = FXCollections.observableArrayList(searchEmptyRooms);
			lvRooms.setItems(pat);
		}

	}

	@FXML
	public void erstelleRaum(ActionEvent event) throws IOException {
		String[] room = new String[3];
		int lower = 4000;
		int upper = 4999;

		String id = String.valueOf((int) (Math.random() * (upper - lower) + lower));
		String beds = txtBetten.getText();
		String patNum = txtPatAnz.getText();

		room[0] = id;
		room[1] = beds;
		room[2] = patNum;

		String newRoom = id + "," + beds + "," + patNum;

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
	// Methode um einen Raum zu löschen
	public void loescheRaum(ActionEvent event) throws IOException {
		String deleteRoom = lvRooms.getSelectionModel().getSelectedItem();
		String[] roomDelete = deleteRoom.split(",");

		application.ReaderWriter.deleteFromTxt(roomDelete[0], "Räume.txt");

		String[] rooms = ReaderWriter.readToArray("Räume.txt");
		showRoomList(rooms);
	}
}
