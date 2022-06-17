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

public class TVController {

	// Variablen um neue Scene zu erzeugen
	private Stage stage;
	private Scene scene;

	// Zugriff auf FXML Elemente
	@FXML
	Button btnHauptmenü;
	@FXML
	ListView<ObservableList> lvOpT = new ListView<ObservableList>();
	

	// Methode um die roomientendaten aus der Text Datei in die TableView einzufügen
	@FXML
	public void tempMethode(ActionEvent event) {
		try {
			zeigeOpListAn();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	public void zeigeOpListAn() throws IOException {

		String[] termine = ReaderWriter.readToArray("Termine.txt");

		ObservableList<String> date = FXCollections.observableArrayList(termine);
		
		ObservableList<String> dateBsp = FXCollections.observableArrayList();
		
		for (int i = 0; i < date.size(); i++) {
			
		
			String[] opdaten = termine[i].split(",");
			
			
			String tid = opdaten[0];
			String patvorname = opdaten[1];
			String patnachname = opdaten[2];
			String persoid = opdaten[3];
			String persovorname = opdaten[4];
			String personachname = opdaten[5];
			String opgrund = opdaten[6];
			String opdatum = opdaten[7];
			
			

			dateBsp.addAll(tid, patvorname, patnachname, persoid, persovorname, personachname, opgrund, opdatum);
			 // Fehler -->Cannot invoke "javafx.scene.control.ListView.getItems()" because "gui.PVController.lvRaum" is null
			//System.out.println(vorname);
			
			
			//Gibt die Daten der Text

			System.out.println(termine[i]);
			
			//System.out.println(Arrays.toString(roomientendaten)); //gibt den inhalt der txt datei wieder
			lvOpT.getItems().addAll(dateBsp); //müsste eigentlich die roomientendaten in die listview eintragen
			
			}
		lvOpT.getItems().addAll(dateBsp);
		//lvRaum.setCellFactory((Callback<ListView<ObservableList>, ListCell<ObservableList>>) roomBsp);
		lvOpT.getItems();
		String temp = "";
		
		
		
		for(String item: dateBsp) {
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
