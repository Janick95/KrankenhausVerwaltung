package gui;

import java.io.IOException;

import application.ReaderWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class RVController {

	// Variablen um neue Scene zu erzeugen
	private Stage stage;
	private Scene scene;

	// Zugriff auf FXML Elemente
	@FXML
	Button btnHauptmenü;
	@FXML
	ListView<ObservableList> lvRaum = new ListView<ObservableList>();
	

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

		ObservableList<String> room = FXCollections.observableArrayList(rooms);
		
		ObservableList<String> roomBsp = FXCollections.observableArrayList();
		
		for (int i = 0; i < room.size(); i++) {
			
		
			String[] roomdaten = rooms[i].split(",");
			
			
			String id = roomdaten[0];
			String bettenanz = roomdaten[1];
			String patanz = roomdaten[2];

			roomBsp.addAll(id, bettenanz, patanz);
			 // Fehler -->Cannot invoke "javafx.scene.control.ListView.getItems()" because "gui.PVController.lvRaum" is null
			//System.out.println(vorname);
			
			
			//Gibt die Daten der Text

			System.out.println(rooms[i]);
			
			//System.out.println(Arrays.toString(roomientendaten)); //gibt den inhalt der txt datei wieder
			lvRaum.getItems().addAll(roomBsp); //müsste eigentlich die roomientendaten in die listview eintragen
			
			}
		lvRaum.getItems().addAll(roomBsp);
		//lvRaum.setCellFactory((Callback<ListView<ObservableList>, ListCell<ObservableList>>) roomBsp);
		lvRaum.getItems();
		String temp = "";
		
		
		
		for(String item: roomBsp) {
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
