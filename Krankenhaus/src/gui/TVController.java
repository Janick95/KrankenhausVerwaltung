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
import javafx.stage.Stage;

public class TVController {

	// Variablen um neue Scene zu erzeugen
	private Stage stage;
	private Scene scene;

	// Zugriff auf FXML Elemente
	@FXML
	Button btnHauptmenü;
	@FXML
	Button btnTerminErstellen;
	@FXML
	Button btnTerminLoeschen;
	@FXML
	TextField txtPatVorn;
	@FXML
	TextField txtPatNachn;
	@FXML
	TextField txtArztVorn;
	@FXML
	TextField txtArztNachn;
	@FXML
	TextField txtOpGrund;
	@FXML
	TextField txtOpDatum;
	@FXML
	ListView<String> lvOpT = new ListView<String>();
	
	@FXML
	public void initialize() throws IOException {
		zeigeOpListAn();
	}
	
	@FXML
	public void zeigeOpListAn() throws IOException {

		String[] termine = ReaderWriter.readToArray("Termine.txt");

		ObservableList<String> date = FXCollections.observableArrayList(termine);
		lvOpT.setItems(date);
		
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
	public void erstelleTermin(ActionEvent event) throws IOException {
		String[] opTermin = new String[8];
		int lowerT = 5000;
		int upperT = 5999;
		int lowerA = 1000;
		int upperA = 1999;
		String idTermin = String.valueOf((int) (Math.random() * (upperT - lowerT))) + lowerT;

		String patVorname = txtPatVorn.getText();
		String patNachname = txtPatNachn.getText();
		
		String idArzt = String.valueOf((int) (Math.random() * (upperA - lowerA))) + lowerA;
		
		String arztVorname = txtArztVorn.getText();
		String arztNachname = txtArztNachn.getText();
		String opGrund = txtOpGrund.getText();
		String opDatum = txtOpDatum.getText();

		opTermin[0] = idTermin;
		opTermin[1] = patVorname;
		opTermin[2] = patNachname;
		opTermin[3] = idArzt;
		opTermin[4] = arztVorname;
		opTermin[5] = arztNachname;
		opTermin[6] = opGrund;
		opTermin[7] = opDatum;
		
		for (int i = 0; i < opTermin.length; i++) {
			opTermin[i].trim();
			opTermin[i].toString().split(",");

		}				
		Alert mesg = new Alert(AlertType.CONFIRMATION);
		mesg.setContentText("Termin hinzugefügt");
		mesg.showAndWait();
		application.ReaderWriter.writeStringIntoTxt(Arrays.toString(opTermin).split(","), "Termine.txt");
	}
	@FXML
	public void loescheTermin(ActionEvent event) throws IOException {	
		//deletePat = lvPatDat01.getSelectionModel().getSelectedItem();
		//application.ReaderWriter.deleteFromTxt(deletePat.toString(), "Patienten.txt"); lvPflegerDat lvAerzteDat
		String deleteOp = lvOpT.getSelectionModel().getSelectedItem();
		System.out.println(deleteOp);
		
		application.ReaderWriter.deleteFromTxt(deleteOp, "Termine.txt");
	}
}
